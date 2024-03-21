% Este programa resuelve el famoso problema de criptografía numérica
% en el que se debe asignar un dígito del 0 al 9 a cada letra de
% las palabras "CROSS", "ROADS" y "DANGER" de modo que la suma de
% "CROSS" y "ROADS" sea igual a "DANGER".

% Predicado principal para encontrar la solución al problema.
solution(C,R,O,S,A,D,N,G,E,C1,C2,C3,C4) :-
    diferent_digits(C,R,O,S,A,D,N,G,E), % Restricciones iniciales
    C > 0, R > 0, S > 0, D is 1, % Asegura que no haya ceros en la suma
    R is (S+S) mod 10, C1 is (S+S) // 10,
    E is (S+D+C1) mod 10, C2 is (S+D+C1) // 10,
    G is (O+A+C2) mod 10, C3 is (O+A+C2) // 10,
    N is (R+O+C3) mod 10, C4 is (R+O+C3) // 10,
    A is (C+R+C4) mod 10.

% Restricciones iniciales: cada dígito asignado a una letra debe ser único.
diferent_digits(C,R,O,S,A,D,N,G,E) :-
    dig(C), dig(R), dig(O), dig(S), dig(A), dig(D), dig(N), dig(G), dig(E),
    \+ C=R, \+ C=O, \+ C=S, \+ C=A, \+ C=D, \+ C=N, \+ C=G, \+ C=E,
    \+ R=O, \+ R=S, \+ R=A, \+ R=D, \+ R=N, \+ R=G, \+ R=E,
    \+ O=S, \+ O=A, \+ O=D, \+ O=N, \+ O=G, \+ O=E,
    \+ S=A, \+ S=D, \+ S=N, \+ S=G, \+ S=E,
    \+ A=D, \+ A=N, \+ A=G, \+ A=E,
    \+ D=N, \+ D=G, \+ D=E,
    \+ N=G, \+ N=E.

% Restricciones iniciales: dígitos del 0 al 9
dig(0). dig(1). dig(2). dig(3). dig(4).
dig(5). dig(6). dig(7). dig(8). dig(9).
