#lang racket

(define (expo n i)
  (cond
    [(< i 1) 1]
    [else (* n (expo n (- i 1)))]))

(define (expo-fast n i)
  (cond
    [(< i 1) 1]
    [(eqv? 0 (modulo i 2)) (* (expo-fast n (* i 0.5)) (expo-fast n (* i 0.5)))]
    [else (* n (expo-fast n (- i 1)))]))

(define (expo-help n i r)
  (cond
    [(< i 1) r]
    [else (expo-help n (- i 1) (* n r))]))

(define (expo-trec n i)
  (expo-help n i 1))

(define (powsum-help lon s)
  (cond
    [(null? lon) s]
    [else (powsum-help (cdr lon) (+ (expt 2 (car lon)) s))]))

(define (powsum-trec lon)
  (powsum-help lon 0))
