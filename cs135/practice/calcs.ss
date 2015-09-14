#lang racket

;coin value calculator
(define (ccalc p n d q)
  (ccalc_fmt (+ p (* n 5) (* 10 d) (* 25 q))))

;movie theatre profit
;movie theatre pays 20 per movie and 0.50 per attendee, everyone pays 5
(define (mprofit a);a is attendees
  (- (* 4.50 a) 20))

(define (ccalc-fmt x)
  (string-append (number->string x) " cents"))