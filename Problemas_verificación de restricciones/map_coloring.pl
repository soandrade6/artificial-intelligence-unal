/*
Este código en Prolog define un problema de colorear un 
mapa donde hay nueve regiones
(representadas por las variables A, B, C, D, E, F, G, H, I) 
que deben ser coloreadas con tres colores diferentes: rojo, azul y verde. 
El objetivo es asignar un color a cada región de manera 
que regiones adyacentes tengan colores diferentes.
*/
% HECHOS.
color(rojo).
color(azul).
color(verde).

% REGLAS
colorea_mapa(A,B,C,D,E,F,G,H,I) :-
color(A), color(B), color(C), color(D), color(E),
color(F), color(G), color(H), color(I),
\+ A=B, \+ A=C, \+ A=D, \+ A=E,
\+ B=C, \+ B=E, \+ B=F,
\+ C=D,\+ C=H, \+ C=G, \+ C=I,
\+ D=E, \+ D=I, \+ E=F, \+ G=H, \+ H=I.