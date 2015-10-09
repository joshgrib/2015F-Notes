#lang eopl

; lab6 2015

; Objectives of lab:  
; Practice with proof by induction.
; Additional practice with recursive definitions of functions that construct lists,
; including ones that don't just look at the first element of an input list.

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Step 0
; Define a function all-pos? that takes a list of numbers and returns #t or #f
; depending on whether all elements are positive.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(define (all-pos? lon)
    "to do")

(define test-all-pos
    (and (all-pos? '(2 1 9 1))
         (all-pos? '(0 0 0))
         (all-pos? '())
         (not (all-pos? '(-1 2 -5)))
         (not (all-pos? '(1 2 -3 4)))
         ))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Step 1 - to show TA
; Have a look at function make-ones which was discussed in lecture.
; Using induction, prove that 
;                             (all-pos? (make-ones n)) for all natural numbers n.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(define (make-ones n) 
    (cond [(eqv? n 0) '()] 
          [else (cons 1 (make-ones (- n 1)))]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Step 2 - to show TA
; Define take() so that it returns the first n elements of list xs,
; assuming that n is at most the length of xs.
; If you know Python, this is like the slice xs[0:n].
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(define (take n xs)
  "to do")

(define test-take 
   (and (equal? (take 0 '(1 2 3 4 5)) '())
        (equal? (take 2 '(1 2 3 4 5)) '(1 2))
        (equal? (take 5 '(a b c d e)) '(a b c d e))
        ))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Step 3 - to show TA
; Define drop() so that it returns all but the first n elements of list xs,
; assuming that n is at most the length of xs.
; If you know Python, this is like the slice xs[n:].
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(define (drop n xs)
  "to do")

(define test-drop
   (and (equal? (drop 0 '(a b c d e)) '(a b c d e))
        (equal? (drop 2 '(a b c d e)) '(c d e))
        (equal? (drop 5 '(a b c d e)) '())
        ))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Step 4
; Assume xs is a list and n is an integer such that 0 <= n <= (length xs).
; Which of the following statements are true?  (Just think about it, you 
; don't have to prove or disprove.
; 
; (a) (length (take n xs)) = n 
; (b) (length (drop n xs)) = (- (length xs) n)
; (c) (drop n (take n xs)) = '()
; (d) (take n (drop n xs)) = '()
; (e) (append (drop n xs) (take n xs)) = xs
; (f) (append (take n xs) (drop n xs)) = xs
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Step 5 - to show TA
; Define a function ascend? that takes a list of numbers and returns 
; a boolean indicating whether it is in ascending order.  That is, non-decreasing,
; with respect to the built-in ordering function <= 
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(define (ascend? lon)
   "to do")

(define test-ascend ; should return #t
    (and (ascend? '())
         (not (ascend? '(3 2 1)))
         (ascend? '(1 2 3))
         (ascend? '(-17 -3 -3 -3 2.04 5008.6))
         (not (ascend? '(1 2 3 4 5 6 7 6 7 8 9 10)))
         (ascend? '(1 20 20 30 30 30 40 50 51 52 53 54 55 56 57))
         ))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Step 6 - to show TA
; Define a function merge that takes two ascending lists and combines their 
; elements into a single ascending list.
; Keep it simple: build up the result list one element at a time.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(define (merge xs ys)
   "to do")

(define test-merge 
  (and (equal? (merge '(1 2 3) '(0 4)) '(0 1 2 3 4))
       (equal? (merge '() '(1 2 3)) '(1 2 3))
       (equal? (merge '(1 2 3) '(100 200 300 400)) '(1 2 3 100 200 300 400))
       (equal? (merge '(100 200 300 400) '(1 2 3)) '(1 2 3 100 200 300 400))
       ))
