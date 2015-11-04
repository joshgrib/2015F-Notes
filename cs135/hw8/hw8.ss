#lang racket

(define (expo n i)
  (cond
    [(>= 0 i) 1]
    [else (* n (expo n (- i 1)))]))
(define test-expo
  (and
   (eqv? (expo 2 0) 1)
   (eqv? (expo 2 1) 2)
   (eqv? (expo 2 2) 4)
   (eqv? (expo 2 6) 64)
   ))

(define (expo-fast n i)
  (cond
    [(>= 0 i) 1]
    [(eqv? 0 (modulo i 2)) (* (expo-fast n (/ i 2)) (expo-fast n (/ i 2)))]
    [else (* n (expo-fast n (- i 1)))]))

(define (expo-help n i r)
  (cond
    [(>= 0 i) r]
    [else (expo-help n (- i 1) (* r n))]))
(define (expo-trec n i)
  (expo-help n i 1))

(define powsum
  (lambda (lon)
    (cond [(null? lon) 0]
          [else (+ (expt 2 (car lon)) (powsum (cdr lon)))])))
(define (powsum-help lon s)
  (cond
    [(null? lon) s]
    [else (powsum-help (cdr lon) (+ s (expt 2 (car lon))))]))
(define (powsum-trec lon)
  (powsum-help lon 0))
  










