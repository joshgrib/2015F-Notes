#lang eopl
; Josh Gribbon - Lab 2

;tells if something is an atom - if it is a single object
(define atom?
  (lambda (x)
    (and (not (pair? x)) (not (null? x)))))

;returns the exclusive-or of the two things - only true if one of the two is true
(define (xor x y)
  (and (or x y) (not (and x y))))

;returns the implies of the two things, returns true unless #t-->#f
(define (impl x y)
  (or (not x) y))

;a test for xor commutativity
(define (test-xor-commute x y)
  (eqv? (xor x y) (xor y x)))

;a test to try all the possible inputs that would satisfy the identity
(define (test-and-absorp x y)  ;  (x /\ (x \/ y)) === x
  (eqv? (and x (or x y)) x))
(define t1
  (test-and-absorp #f #f))
(define t2
  (test-and-absorp #f #t))
(define t3
  (test-and-absorp #t #f))
(define t4
  (test-and-absorp #t #t))

;a test to combine all the others
;returns t iff they all pass(define w1
(define t1234
  (and t1 t2 t3 t4))

;defining or idempotence
(define (test-or-idem x)
  (eqv? (or x x) x))

;tests for or idempotence
(define u1
  (test-or-idem #t))
(define u2
  (test-or-idem #f))
(define u12
  (and u1 u2))

;testing if implies is commutative
(define (test-impl-commute x y)
  (eqv? (impl x y) (impl y x)))

;tests for imples commutativity
(define w1 ;t
  (test-impl-commute #t #t))
(define w2 ;f
  (test-impl-commute #t #f))
(define w3 ;f
  (test-impl-commute #f #t))
(define w4 ;t
  (test-impl-commute #f #f))
(define w1234 ;f
  (and w1 w2 w3 w4))

;returns true iff true of the inputs are true
(define (f x y z)
  (and (or
        (and x y) 
        (and y z) 
        (and x z)) 
       (not (and x y z))))

;returns true if all the scenarios that are supposed to be true are
(define j-true
  (and 
   (f #t #t #f) 
   (f #t #f #t) 
   (f #f #t #t)))
;returns true if all the scenarios that are supposed to be false are
(define j-false
  (not (and 
   (f #f #f #f) 
   (f #f #f #t)
   (f #f #t #f)
   (f #t #f #f)
   (f #t #t #t))))
(define j-total
  (and j-true j-false))


