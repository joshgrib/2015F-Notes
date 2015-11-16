#lang eopl
; lab10 assignment 2015 

; Objectives of lab:  
; Learn about role-based access control, RBAC for short. 
; Get familiar with transitive closure.

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Some functions that may be helpful.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(define (last lst)
  ; The last element of lst, assuming lst is a non-empty list
  (cond [(null? (cdr lst)) (car lst)]
        [else (last (cdr lst))]))

(define (reduce f ys b)  ; See lecture 17
  (cond [(null? ys) b]
        [else (f (car ys) (reduce f (cdr ys) b))]))

(define (my-or p q) (or p q)) ; The or function. Hack to get around drRacket treatment of "or".

(define (member? x xs)
  ; Whether x is a member of list xs; fancy version
  (reduce my-or (map (lambda (y) (equal? y x)) xs) #f))

(define (filter lst pred?)
  ; Assume lst is a list of things and pred? is a function from things to boolean.
  ; Return the sub-set of lst consisting of things that satisfy pred?
  ; For example (filter '(1 2 3 4 5) even?) = '(2 4)
  (cond [(null? lst) '()]
        [(pred? (car lst)) (cons (car lst) (filter (cdr lst) pred?))]
        [else (filter (cdr lst) pred?)]))

(define (mk-id lst) ; make the identity relation on elements of lst
  (cond [(null? lst) '()]
        [else (cons (list (car lst) (car lst)) (mk-id (cdr lst)))]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; A toy database of information related to access control in an imaginary
; software development project.  I am representing sets by lists without duplicates,
; and relations by sets of ordered pairs.  For simplicity, I am not distinguishing
; between different kinds of access (read/write/execute/etc).  
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(define PEOPLE '(Leila Tom Ana Paulo Mike Sue))
(define ROLES '(teammember tester programmer supervisor anyone))
(define OBJECTS '("/Sue/proj/main.ss" "/Sue/personal/contacts" "/Team/source/Snooze.java"
                  "/Team/tests/test1.ss" "/Team/lab9.ss" "/Team/advertising.html"))

(define PERMS ; relates a role to an object the role has permission to access
  '((teammember "/Team/lab9.ss") 
    (tester "/Team/tests/test1.ss") 
    (programmer "/Team/source/Snooze.java")
    (supervisor "/Team/tests/test1.ss")
    (anyone "/Team/advertising.html")
    (supervisor "/Team/source/Snooze.java")
    (supervisor "/Team/admin/Salaries.xls") ))

(define AUTH ; relates a person to a role they are authorized for
  '((Leila supervisor) 
    (Tom tester)
    (Tom marketer)
    (Ana programmer)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Step 0 
; Review the following solutions, which implement part of the access control 
; interface.  The idea is that when user u tries to access object o, the operating 
; system checks whether u is authorized for some role r that has permission to access o.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(define (role-has-perm? role obj)
  ; Whether role has permission for obj
  ; For example (role-has-perm? 'tester "/Team/tests/test1.ss") = #t 
  (member? (list role obj) PERMS))

(define (has-perm? pers obj)
  ; Assume pers is in PEOPLE.  Check whether pers is authorized for some role r such
  ; that r has permission for obj.  
  ; For example, (has-perm? 'Ana "/Team/source/Snooze.java") = #t
  ; because (list 'Ana 'programmer) is in AUTH and (list 'programmer "/Team/source/Snooze.java") 
  ; is in PERMS.
  (has-perm-any? (roles-of pers ROLES) obj))

(define (roles-of pers roleList)
  ; List of r in roleList such that (pers,r) is in AUTH 
  (filter roleList (lambda (r) (member? (list pers r) AUTH))))

(define (has-perm-any? roleList obj)
  ; whether any r in roleList has permission for obj
  (reduce (lambda (r any?) (my-or (role-has-perm? r obj) any?)) roleList #f))

(define test-has-perm?
  (and (has-perm? 'Ana "/Team/source/Snooze.java")
       (not (has-perm? 'Ana "/Sue/proj/main.ss"))))

(define test-has-perm-any ; should be #t
  (and (not (has-perm-any? ROLES "cat"))
       (has-perm-any? ROLES "/Team/lab9.ss")
       (has-perm-any? '(tester) "/Team/tests/test1.ss") 
       (not (has-perm-any? '(anyone) "/Team/tests/test1.ss"))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Step 1 - to show TA 
; Implement the following three functions.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(define (compose-one pair rel)
  ; Assuming pair is (x y), make all the pairs (x z) such that (y z) is in rel.
  ; Hint: by recursion on rel.
  (cond
    [(null? rel) '()]
    [(eqv? (cadr pair) (caar rel)) (cons 
                                 (list (car pair) (cadar rel)) 
                                 (compose-one pair (cdr rel)))]
    [else (compose-one pair (cdr rel))]))

(define test-compose-one ; should be #t
  (equal? (compose-one '(a 2) '((2 "thing") (1 "thing") (2 "it"))) 
	  '((a "thing") (a "it")))) 

(define (compose-rel rel0 rel1)
  ; Assume rel0 and rel1 are sets of pairs.
  ; Return the composition "rel1 o rel0" of rel1 after rel0.  
  ; Hint: use recursion on rel0, using compose-one.
  ; Note: it's ok to allow duplicate pairs.  (As in the second test case below.)
  (cond [(null? rel0) '()]
        [else (append (compose-one (car rel0) rel1)
                      (compose-rel (cdr rel0) rel1))]))

(define test-compose-rel ; should be #t
  (and (member? '(Ana "/Team/source/Snooze.java") 
                (compose-rel AUTH PERMS))
       (member? '(a "thing") 
                (compose-rel '((a 1) (a 2) (b 2)) 
			     '((2 "thing") (1 "thing"))))))

(define (has-perm?-alt pers obj)
  ; Alternate implementation of has-perm?
  ; Just check for membership in the composed relation  AUTH o PERMS
  ; using member? and compose-rel.
  (member? (list pers obj) (compose-rel AUTH PERMS)))

(define test-has-perm?-alt
  (and (has-perm?-alt 'Ana "/Team/source/Snooze.java")
       (not (has-perm?-alt 'Ana "/Sue/proj/main.ss"))))
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Step 2 - to show TA 
; 
; The tables above seem very incomplete, e.g., shouldn't a supervisor have permission
; for anything a tester or programmer can access?  We could extend the tables with
; that in mind, but that would increase the size of the data.  Better to put
; some structure on the roles.
;
; The idea is to add another component to our policy: a relation between roles that
; expresses how one role is subsumed by another more general role.  That relation
; is partly expressed by the table SUBSUME below.  For making access control decisions
; we want to consider that 'supervisor is subsumed by 'anyone --that's the transitive
; closure of SUBSUME.  
;
; Provide the "to do" implementations.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(define SUBSUME '((supervisor programmer) 
                  (supervisor tester) 
                  (supervisor marketer)
                  (programmer teammember) 
                  (tester teammember) 
                  (teammember anyone)))

(define (trans-close rel items)
  ; Assume items is a list and rel is a relation on items.
  ; Return the transitive closure of rel.
  ; Note: it's ok to allow duplicate pairs in the result.
  ; Hint: test it by trying (trans-close SUBSUME ROLES)
  (trans-help rel (length items)))

(define (trans-help rel N)
  ; The union of composing rel with itself 1, 2, ... N times,
  ; assuming rel is a relation and N >= 1.  (See lecture 18.)
  ; There may be duplicate pairs, because this function is using
  ; append to form unions (and because compose-rel can make duplicates).
  (cond
    [(= N 1) rel]
    [else (append rel (compose-rel rel (trans-help rel (- N 1))))]))


(define (refl-trans-close rel items)
  ; The reflexive, transitive closure of rel which is a relation on items.
  (append (mk-id items) (trans-close rel items)))
;

(define (has-perm*? pers obj)
  ; Whether pers is authorized for some role that is transitively subsumed by a role r 
  ; that has permission for obj.  
  ; For example, (has-perm*? 'Leila "/Team/advertising.html") = #t because Leila is
  ; authorized for supervisor which is transitively subsumed by anyone, and anyone
  ; has permission for "/Team/advertising.html").  
  ; For another example, (has-perm*? 'Leila "/Team/admin/Salaries.xls") = #t
  ;
  ; Hint: This function needs to check whether the pair (pers obj) is in the composed relation
  ;       PERMS o SUBSUME* o AUTH
  ;       where SUBSUME* is the reflexive, transitive closure of SUBSUME.
  ; Hint: composition of relations is associative, so you can use compose-rel twice, to compute
  ;       either (PERMS o SUBSUME*) o AUTH  or  PERMS o (SUBSUME* o AUTH)
  ; SOLUTION: mine computes PERMS o (SUBSUME* o AUTH)
  (member? (list pers obj) (compose-rel (compose-rel AUTH (trans-close SUBSUME ROLES)) PERMS)))

(define test-has-perm*? 
  (and (has-perm*? 'Leila "/Team/advertising.html")
       (has-perm? 'Leila "/Team/admin/Salaries.xls")))
  
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Step 3 - to show TA
; For this function, the idea is to avoid the need to search for a chain of subsumptions.
; The user has to present their "credentials", i.e., a non-empty list of roles which 
; they claim are successively subsumed.  Then the system checks whether (a) pers is
; authorized for the first role in the list, (b) each two successive roles in the list 
; are in the SUBSUME relation, and (c) the last role has permission for obj. 
; (This is similar to how certificate chains are used in crptography.)
;
; Implement these functions any way you like.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(define (has-perm-creds? pers roles obj)
  ; Hint: This can be the 'and' of the three checks (a), (b), (c) above.
  ; You already have the ingredients for (a) and (c).  For (b), write and use
  ; a separate function.
  (and
   (member (list pers (car roles)) AUTH)
   (path-subsume? roles)
   (member? (list (get-last roles) obj) PERMS)));to-do

(define (get-last lst)
  (cond
    [(eqv? (length lst) 1) (car lst)]
    [else (get-last (cdr lst))]))

(define (path-subsume? lst)
  (cond
    [(eqv? (length lst) 1) #t]
    [else (and
           (member? (list (car lst) (cadr lst)) (trans-close SUBSUME ROLES))
           (path-subsume? (cdr lst)))]));to-do

(define test-path-subsume? ; Should be #t
  (and (path-subsume? '(supervisor programmer teammember))
       (path-subsume? '(supervisor))
       (not (path-subsume? '(tester supervisor anyone)))))

(define test-has-perm-creds ; Should be #t
  (and (has-perm-creds? 'Leila '(supervisor tester teammember) "/Team/lab9.ss")
       (not (has-perm-creds? 'Leila '(tester teammember) "/Team/lab9.ss"))
       (has-perm-creds? 'Leila '(supervisor teammember) "/Team/lab9.ss")))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(define test-all
  (and
   test-compose-one
   test-compose-rel
   test-has-perm?-alt
   test-has-perm*?
   test-path-subsume?
   ))
   
