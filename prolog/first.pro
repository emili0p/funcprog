%==============================
%FUNCTOR LO DE ROJO, ARIDAD CUANTOS ARGUMENTOS TIENE
%==============================
%==============================
%HECHOS
%==============================
filosofo(descartes).
filosofo(platon).
filosofo(aristoteles).
filosofo(socrates).

fisico(einstein).
fisico(newton).
fisico(galileo).
fisico(tesla).

matematico(newton).
matematico(einstein).
matematico(gauss).
matematico(euler).

quimico(bohr).
quimico(curie).
quimico(lavoisier).
quimico(dalton).

astronomo(copernico).
astronomo(hubble).
astronomo(webb).
astronomo(galileo).
%==============================
%RELACIONES MAESTRO-ALUMNO
%==============================
maestro(einstein, tesla).
maestro(lavoisier, curie).
maestro(copernico, galileo).
maestro(platon, aristoteles).

%==============================
%REGLAS
%==============================
sabe_matematicas(X) :-
    matematico(X).
sabe_astronomia(X) :-
    astronomo(X).
sabe_quimica(X) :-
    quimico(X).
sabe_filosofia(X) :-
    filosofo(X).
sabe_fisica(X) :-
    fisico(X).
%==============================
%REGLAS COMPUESTAS
%==============================
cientifico_integral(X) :-
    fisico(X),
    matematico(X).
pensador(X) :-
    filosofo(X),
    fisico(X).
erudito(X) :-
    matematico(X),
    filosofo(X).
erudito(X) :-
    fisico(X),
    filosofo(X).



