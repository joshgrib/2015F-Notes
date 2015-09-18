#lang eopl

; lab3 assignment 2015

; Objectives of lab: Get familiar with lists and functions.

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Step 0
; You should have been given this file online.  Save your own copy as lab3sol.scm 
; so you can make your own additions as instructed.
;
; Now, take a peek at the _specifications_ of the following functions. But ignore
; the code since it uses features of Scheme we aren't studying yet.
; Then go to Step 1.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

; nth element of a list, assuming it exists
(define (nth n xs) 
  (cond ((eqv? n 0) (car xs))
        (else (nth (- n 1) (cdr xs)))))

; Assume f is an n-ary function and xs is a list of n-tuples.
; Return the list of pairs  (t v)  where t is in xs and v is (f t).
(define (graph f xs)
  (map (lambda (x) (list x (apply f x))) xs))

; Display a non-empty list on successive lines.
(define (dispLst xs)
  (cond ((null? (cdr xs)) (display (car xs)))
        (else (begin (display (car xs)) (newline) (dispLst (cdr xs))))))

; Assume f is an n-ary function and xs is a list of n-tuples.
; Return the list of values (f t) where t is in xs.
(define (mapapp f xs) (map (lambda (x) (apply f x)) xs))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Step 1
; Have a quick look at the following definitions.  Then see what they do by
; evaluating the following expressions, one at a time, at the interactive prompt.
; 
; bVals1
; bVals2
; bVals3
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

; List of all 1-tuples of boolean values
(define bVals1 '((#f) (#t)))

; List of all 2-tuples of boolean values
(define bVals2 '((#f #f) (#f #t) (#t #f) (#t #t)))

; List of all 3-tuples of boolean values
(define bVals3 
  (append (map (lambda (x) (cons #f x)) bVals2) 
          (map (lambda (x) (cons #t x)) bVals2)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Step2 
; Evaluate each of these expressions and try similar ones.  The point is to 
; get familiar with lists and how DrRacket displays lists.  
;                     
; (car bVals1)
; (cdr bVals1)
; (car (cdr bVals1))
;
; (car bVals2)
; (nth 0 bVals2)
; (nth 1 bVals2)
; (nth 2 bVals2)
; (nth 3 bVals2)
;
; (nth 0 bVals3)
; (nth 7 bVals3) 
; 
; (dispLst bVals1)
; (dispLst bVals2)
; (dispLst bVals3)
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

; Some 2-ary boolean functions for use in Step 3 below.
(define (xor x y)
  (and (or x y) (not (and x y))))
(define (impl x y)
  (or (not x) y))
(define (biimp x y) 
  (eqv? x y))
(define (and2 x y) ; need this because the built-in 'and' has special syntax
  (and x y))
(define (or2 x y) 
  (or x y))

; Some 3-ary boolean functions
(define (f1 x y z)
  (and (or (not x) y) z))
(define (f2 x y z)
  (and z (impl x y)))   
(define (and3 x y z)
  (and x y z))
(define (or3 x y z) 
  (or x y z))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Step 3 
; Note that bVals2 corresponds to the rows of a truth table for 2 variables.
; Generate the truth table for xor by evaluating the following expression:
;
; (graph xor bVals2)
;
; Now display the table nicely by evaluating this:
; 
; (dispLst (graph xor bVals2))
; 
; Now make the tables for some other functions:
; (dispLst (graph impl bVals2))
; (dispLst (graph f1 bVals3))
; (dispLst (graph and2 bVals2))  ; Note that it won't work using the built-in 'and'.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Step 4 - to show TA
; Display the truth tables for 'or2' and 'f2', like in Step 3.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

; For use in Step 5.
(define (test-xor-commute x y) 
  (biimp (xor x y) (xor y x)))
(define (test-and-absorp x y)
  (biimp (and x (or x y)) x))
(define (test-wrong-law x y)
  (biimp (impl x y) (impl y x)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Step 5 
; In lab 2 we manually tested some equivalences.  Now we can use 'graph' 
; to apply a boolean function to all possible arguments.  Let's use that to
; automate testing.
;
; Recall that two expressions, say E1 and E2, are equivalent just in case the
; single expression  (biimp E1 E2)  is true in all cases.
; 
; Evaluate the following:
; (graph test-xor-commute bVals2)
; (graph test-and-absorp bVals2)
; (graph test-wrong-law bVals2)  
; The last one is not a valid law: p-->q is not equivalent to q-->p.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Step 6 
; For testing equivalences, we just want to look at the result values.  That's
; what function 'mapapp' will do for us.  Try it:
; (mapapp xor              bVals2)
; (mapapp not              bVals1)
; (mapapp f1               bVals3)
; (mapapp test-xor-commute bVals2)
; (mapapp test-and-absorp  bVals2)
; (mapapp test-wrong-law   bVals2)  
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Step 7 - to show TA
; Define test-not-or to test the deMorgan law (using - for negation):  
;   -(p or q) = -p & -q
; Check it using mapapp and bVals2
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Step 8 - to show TA
; Define test-and-over-or to test this distributive law:  
;   p & (q or r) = (p & q) or (p & r)
; Check it using mapapp and bVals3
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Step 9 - to show TA
; Define a test function to check whether this is a valid law:
;   p --> q = -p --> -q
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;




