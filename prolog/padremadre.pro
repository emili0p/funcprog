/* 
   HECHOS BASE
   */

/* PADRES */

padre(roberto, carlos).
padre(roberto, patricia).
padre(roberto, miguel).

padre(carlos, daniel).
padre(carlos, sofia).

padre(miguel, andres).
padre(miguel, camila).

padre(jose, laura).
padre(jose, ricardo).

padre(ricardo, valeria).
padre(ricardo, fernando).

padre(daniel, mateo).

padre(andres, lucia).


/* MADRES */

madre(elena, carlos).
madre(elena, patricia).
madre(elena, miguel).

madre(laura, daniel).
madre(laura, sofia).

madre(silvia, andres).
madre(silvia, camila).

madre(marta, laura).
madre(marta, ricardo).

madre(patricia, valeria).
madre(patricia, fernando).

madre(paula, mateo).

madre(karla, lucia).


/*    REGLAS
   */

/* Relaciones básicas */

hijo(X,Y) :-
    padre(Y,X).

hijo(X,Y) :-
    madre(Y,X).

hija(X,Y) :-
    padre(Y,X).

hija(X,Y) :-
    madre(Y,X).

hermano(X,Y) :-
    padre(P,X),
    padre(P,Y),
    madre(M,X),
    madre(M,Y),
    X \= Y.

hermana(X,Y) :-
    padre(P,X),
    padre(P,Y),
    madre(M,X),
    madre(M,Y),
    X \= Y.


/* Relaciones intermedias */

abuelo(X,Y) :-
    padre(X,Z),
    padre(Z,Y).

abuelo(X,Y) :-
    padre(X,Z),
    madre(Z,Y).

abuela(X,Y) :-
    madre(X,Z),
    padre(Z,Y).

abuela(X,Y) :-
    madre(X,Z),
    madre(Z,Y).

tio(X,Y) :-
    hermano(X,Z),
    padre(Z,Y).

tio(X,Y) :-
    hermano(X,Z),
    madre(Z,Y).

tia(X,Y) :-
    hermana(X,Z),
    padre(Z,Y).

tia(X,Y) :-
    hermana(X,Z),
    madre(Z,Y).

primo(X,Y) :-
    padre(PX,X),
    padre(PY,Y),
    hermano(PX,PY),
    X \= Y.

primo(X,Y) :-
    madre(MX,X),
    madre(MY,Y),
    hermana(MX,MY),
    X \= Y.

prima(X,Y) :-
    padre(PX,X),
    padre(PY,Y),
    hermano(PX,PY),
    X \= Y.

prima(X,Y) :-
    madre(MX,X),
    madre(MY,Y),
    hermana(MX,MY),
    X \= Y.


/* Relaciones avanzadas */

ancestro(X,Y) :-
    padre(X,Y).

ancestro(X,Y) :-
    madre(X,Y).

ancestro(X,Y) :-
    padre(X,Z),
    ancestro(Z,Y).

ancestro(X,Y) :-
    madre(X,Z),
    ancestro(Z,Y).

descendiente(X,Y) :-
    ancestro(Y,X).

familiar_directo(X,Y) :-
    padre(X,Y).

familiar_directo(X,Y) :-
    madre(X,Y).

familiar_directo(X,Y) :-
    hermano(X,Y).

familiar_directo(X,Y) :-
    hermana(X,Y).

familiar_directo(X,Y) :-
    abuelo(X,Y).

familiar_directo(X,Y) :-
    abuela(X,Y).


/*    CONSULTAS DE PRUEBA


abuelo(X, mateo).

hermano(X, sofia).

ancestro(X, lucia).

tio(X, mateo).

primo(X, lucia).

*/
