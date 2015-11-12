#lang eopl
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Homework 9, CS 135 2015
;
; Read Rosen 9.1-9.3 
; Do 9.1 exercises 2, 4, 6defgh, 10, 12, 42, 44 
; Do exercises A and B below.  Don't worry about efficiency, just correctness.
; 
; In this code, relations are represented by lists of ordered pairs, without 
; duplicate pairs.  The universe is s-expressions, i.e., the domain and codomain
; of every relation is the set of s-expressions. 
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Here are some functions that manipulate sets and relations represented by lists 
; without duplicates.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(define (eq-set? set0 set1) 
  ; Assuming set0 and set1 are lists without duplicates, 
  ; return true or false depending on  whether they the same set.
  (and (sub-set? set0 set1) (sub-set? set1 set0)))

(define (sub-set? set0 set1)
  ; Assuming set0 and set1 are lists without duplicates,
  ; return true or false depending on whether every element of set0 is in set1.
  (cond [(null? set0) #t]
        [else (and (member (car set0) set1)
                   (sub-set? (cdr set0) set1))]))
(define (no-dupes lst)
  ; Return true or false depending on whether there are duplicate elements in lst.
  (cond [(null? lst) #t]
        [(member (car lst) (cdr lst)) #f] ; found a duplicate
        [else (no-dupes (cdr lst))]))

(define (remdupes lst)
  ; Converts lst to a set by removing duplicate elements.
  (cond [(null? lst) '()]
        [(member (car lst) (cdr lst)) (remdupes (cdr lst))]
        [else (cons (car lst) (remdupes (cdr lst)))]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Exercise A.  Below is an incomplete and incorrect implementation of function
; compose-rel that composes two relations.  Your job is to finish it and fix it.
; 
; Do not read further until you have studied Definition 6 in section 9.1 of Rosen.
; Hints: First you need to implement function compose-rel.  Do your own testing,
; perhaps just the eq-set? part of the tests first.  Then deal with the no-dupes
; part of the tests.  You will need to make a small change to compose-rel.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(define (compose-rel-help rel0 rel1)
  (cond [(null? rel0) '()]
        [(not (no-dupes rel0)) (compose-rel (remdupes rel0) rel1)]
        [(not (no-dupes rel1)) (compose-rel rel0 (remdupes rel1))]
        [else (append (compose-one (car rel0) rel1)
                      (compose-rel (cdr rel0) rel1))]))

(define (compose-rel rel0 rel1)
  ; Assume rel0 and rel1 are sets of pairs (i.e. no duplicate pairs).
  ; Return the composition of rel1 after rel0.  In math: rel1 o rel0
  (cond
    [(no-dupes (compose-rel-help rel0 rel1)) (compose-rel-help rel0 rel1)]
    [else (remdupes (compose-rel-help rel0 rel1))]))

(define (compose-one p rel)
  ; Assume that p is a pair (i.e., two-element list).  Make a relation
  ; by connecting p with the relation rel.  
  ; Examples: 
  ; (compose-one '(a 3) '((1 this) (3 this) (3 that))) = '((a this) (a that))
  ; (compose-one '(a 2) '((1 this) (3 this) (3 that))) = '()
  (cond
    [(null? rel) '()]
    [(eqv? (cadr p) (caar rel)) (cons 
                                 (list (car p) (cadar rel)) 
                                 (compose-one p (cdr rel)))]
    [else (compose-one p (cdr rel))]))

;Some tests for exercise A
(define test-compose-rel-1 ; Should be #t.  Same for the other tests.
  (and (eq-set? (compose-rel '((a 1) (a 2) (b 3)) '((1 this) (3 this) (3 that)))
                '((a this) (b this) (b that)))
       (no-dupes (compose-rel '((a 1) (a 2) (b 3)) '((1 this) (3 this) (3 that))))))

(define test-compose-rel-2 
  (and (eq-set? (compose-rel '((a 1) (a 2) (b 3)) '((1 this) (3 this) (3 that) (2 this)))
                '((a this) (b this) (b that)))
       (no-dupes (compose-rel '((a 1) (a 2) (b 3)) '((1 this) (3 this) (3 that) (2 this))))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Exercise B.  Implement the following function.
; This is Definition 7 in Rosen section 9.1.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(define (compose-rel-pow rel n)
  ; Assume rel is a set of pairs (i.e., no duplicate pairs).
  ; Return the composition of rel with itself to the nth power
  (cond
    [(eqv? n 0) '()]
    [(eqv? n 1) rel]
    [else (compose-rel rel (compose-rel-pow rel (- n 1)))]))

(define parent '((Kathrine Michael) 
                 (Joseph Michael) 
                 (Samuel Joseph) 
                 (Crystal-Lee Joseph) 
                 (Kathrine Jermaine) 
                 (Joseph Jermaine) 
                 (Kathrine Janet) 
                 (Joseph Janet) ))

; Tests for exercise B
(define test-rel-pow-1
  (and (eq-set? (compose-rel-pow parent 1) parent)
       (no-dupes (compose-rel-pow parent 1))))

(define test-rel-pow-2
  (and (eq-set? (compose-rel-pow parent 2) 
                '((Samuel Michael) (Samuel Jermaine) (Samuel Janet) (Crystal-Lee Michael) (Crystal-Lee Jermaine) (Crystal-Lee Janet)))
       (no-dupes (compose-rel-pow parent 2))))
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;A function to test the whole assignment
(define test-all
  (and
   test-compose-rel-1
   test-compose-rel-2
   test-rel-pow-1
   test-rel-pow-2))
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Exercise C OPTIONAL EXTRA CHALLENGE 
; Make compose-rel-pow-alt which is the same function as compose-rel-pow but 
; implemented using tail recursion.  
; Alert: it's a little tricky.  
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

