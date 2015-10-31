#lang eopl
; lab8 assignment 2015

; Objectives of lab:  
; Practice with tail recursion.
; Practice with induction.

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Step 0 
; Study this example.  Function prod has a direct recursive definition and it 
; computes the product of a list.  Function prod-alt uses a tail-recursive helper
; function similar to the sum function discussed in lecture.   To understand how
; it works, try calculating by hand, like this:
; 
;    (prod-alt '(2 3 1))
;  = (prod-help '(2 3 1) 1)   why? to store the product
;  = (prod-help '(3 1) 2)     why? 2*1=2
;  = ...
;  = (prod-help '(1) 6)
;  = (prod-help 6)
;  = 6
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(define (prod lon)
  ; assume lon is a list of numbers
  (cond [(null? lon) 1]
        [else (* (car lon) (prod (cdr lon)))]))

(define (prod-alt lon) 
  (prod-loop lon 1))

(define (prod-loop lon n)
  (cond [(null? lon) n]
        [else (prod-loop (cdr lon) (* (car lon) n))]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Step 1 - to show TA
; Here is a function that finds the maximum value in a non-empty list of numbers.
; Define max-alt that does the same thing, but using a tail-recursive helper
; function called max-help.  
; Think carefully about the top-level call of your helper, i.e., how does
; max-alt call max-help.
;
; (By the way, the built-in max function actually handles any number of arguments,
; and is doubtless implemented using tail-recursion.  For this exercise,
; only use max with two arguments.)
;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(define (my-max lon) ; assume lon is non-null
  (cond [(null? (cdr lon)) (car lon)]
		  [else (max (car lon) (my-max (cdr lon)))]))

(define (max-alt lon) 
  (max-loop (car lon) (cdr lon)))

(define (max-loop n lon)
  (cond [(null? lon) n]
        [(> (car lon) n) (max-loop (car lon) (cdr lon))]
        [else (max-loop n (cdr lon))]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Step 2 - review proof in lect12 slides that (fast-fact n) = (fact n) for all n.
; To show TA:
; Using similar reasoning, prove that 
;    (prod lon) = (prod-alt lon)  for any list of numbers, lon
; You can do this using pencil and paper.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Step 3 
; To show TA:
; Using similar reasoning, prove that 
;    (my-max lon) = (max-alt lon)  for any list of numbers, lon
; You can do this by pencil and paper.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
