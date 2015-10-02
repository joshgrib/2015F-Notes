#lang eopl

; lab5 assignment 2015

; Objectives of lab:  
; Practice with recursive definitions of functions that construct lists.

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Step 0
; Save your own copy as lab5sol.ss so you can make your own additions as instructed.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Step 1
; Evaluate the following, to get familiar with these built-in functions.
; Some of these expressions will raise errors.  
; (reverse '(a b c))
; (append '(a b c) '(d e f))
; (append '(a b c) '(d e f) '(g h))
; (append "abc" "def")  ;not lists
; (append 'a '(b c d))  ; a is not a list
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Step 2
; Implement the following function.  As a way of giving examples, I am giving
; a test function that should return #T if your implementation is correct.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(define (squares xs)
  ; Assume xs is a list of integers.  Return a list of their squares.
  (cond
    ((null? xs) '())
    (else (append 
           (list (* (car xs) (car xs))) 
           (squares (cdr xs))))))

(define test-squares
  (and (equal? (squares '(3 2 7 5 2))
	                '(9 4 49 25 4))
       (equal? (squares '(2 -1))
               '(4 1))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Step 3
; Implement the following function.  
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(define (pair-sums lint)
  ; Assume lint is a list of integer pairs.
  ; Return a list of sums of those pairs.
  (cond
    ((null? lint) '())
    (else (append 
     (list (+ 
            (car (car lint)) 
            (car (cdr (car lint))))) 
     (pair-sums (cdr lint))))))

(define test-pair-sums
  (and (equal? (pair-sums '((1 9) (6 2)) )
               '(10 8) )
       (equal? (pair-sums '((-1 9) (2 2) (0 0)) )
               '(8 4 0)) ))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Step 4 - to show TA
; Implement the following function.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(define (rev-triples lot)
  ; Assume lot is a list of 3-element lists.
  ; Return the same list but with the triples reversed.
  (cond
    ((null? lot) '())
    (else (append 
     (list (reverse (car lot)))
     (rev-triples (cdr lot))))))

(define test-rev-triples
  (and (equal? (rev-triples '((a b c) (d e f) (g h i)))
               '((c b a) (f e d) (i h g)))
       (equal? (rev-triples '((1 2 3) (4 5 6)))
               '((3 2 1) (6 5 4)))
       (equal? (rev-triples '())
               '()) ))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Step 5 - to show TA
; Implement the following function.  It's a tricky problem.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(define (adj-pair-sums lint)
  ; Assume lint is a list of integers.
  ; Return a list of sums of adjacent pairs.
  (cond
    ((null? lint) '())
    ((null? (cdr lint)) '())
    (else (append
           (list (+ (car lint) (car (cdr lint)))) 
           (adj-pair-sums (cdr lint))))))

(define test-adj-pair-sums
  (and (equal? (adj-pair-sums '(1 1 1))
               '(2 2) )
       (equal? (adj-pair-sums '(1 2 3 4)) 
               '(3 5 7) )
       (equal? (adj-pair-sums '(-2 7)) 
               '(5) )))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Step 6 
; Implement the following function.  
; Hint: use the built-in max function.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(define (max-help ml)
  (cond
    ((null? ml) 0)
    (else
     (max (car ml) (max-help (cdr ml))))))

(define (max-of-lists xss)
  ; Assuming xss is a list of non-empty lists of numbers, return 
  ; the list of their maxima.
  (cond
    ((null? xss) '())
    (else
     (append
      (list (max-help (car xss)))
      (max-of-lists (cdr xss))))))

(define test-max-of-lists
  (and (equal? (max-of-lists '((1 2 3) (100) (100 200)))
               '(3 100 200))
       (equal? (max-of-lists '())
               '()) ))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Step 7 - to show TA
; Implement the following, using your solution from step 6. 
; Hint: Implement a function to check whether a list is a non-empty list of numbers,
; and another function to check whether a list is a list of non-empty number lists.
; Then implement max-of-all.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(define (empt-help el)
  (cond
    ((null? el) #t)
    ((not (null? (car el))) (empt-help (cdr el)))))

(define (max-of-all xss)
  ; Assume that xss is a list, but nothing more.
  ; If xss is not a non-empty list of non-empty lists of numbers, 
  ; return 'max-of-all-error. 
  ; If xss is a non-empty list of non-empty lists of numbers, return the larges number 
  ; that occurs.
  (cond
    ((null? xss) 'max-of-all-error)
    ((empt-help xss) 'max-of-all-error)
    (else (max-of-lists xss))))

(define test-max-of-all
  (and (equal? (max-of-all '((1 2 3) (100) (100 200)))
               200 )
       (equal? (max-of-all '()) ; input is empty
               'max-of-all-error)
       (equal? (max-of-all '((1 2 3) ()) ) ; contains empty
               'max-of-all-error)
       (equal? (max-of-all '((1 2 3) x)) ; isn't a list of number lists
               'max-of-all-error)
       (equal? (max-of-all '((1 2 3) (1 x 3))) ; isn't a list of number lists
               'max-of-all-error)
       (equal? (max-of-all '((1)))
               1) ))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Step 8 - optional
; Evaluate the following.  So you can see that max allows varying numbers of
; arguments, just like 'and'.  And you can see how to use such a function to apply
; to a specific list.
; (max 1 2 3)
; (max -1 23 7)
; (apply max '(1 2 3))
; (apply max '(-1 23 7))
; This gets an error:
; (max '(1 2 3))
; What does that tell you about the type of max?
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
