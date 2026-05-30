/* Primera generación */
padre(martina, carlos).
madre(elena, carlos).

padre(roberto, patricia).
madre(elena, patricia).

padre(roberto, miguel).
madre(elena, miguel).

/* Segunda generación */
padre(carlos, daniel).
madre(laura, daniel).

padre(carlos, sofia).
madre(laura, sofia).

padre(miguel, andres).
madre(silvia, andres).

padre(miguel, camila).
madre(silvia, camila).

padre(jose, laura).
madre(marta, laura).

padre(jose, ricardo).
madre(marta, ricardo).

padre(ricardo, valeria).
madre(patricia, valeria).

padre(ricardo, fernando).
madre(patricia, fernando).

/* Tercera generación */
padre(daniel, mateo).
madre(paula, mateo).

padre(andres, lucia).
madre(karla, lucia).

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

abuelo(X, mateo).

hermano(X, sofia).

ancestro(X, lucia).

tio(X, mateo).

primo(X, lucia).

*/
