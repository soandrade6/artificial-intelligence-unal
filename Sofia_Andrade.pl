% Definición de acciones relacionadas con la salud y el bienestar

accion('hacer ejercicio regularmente', Beneficio, Tiempo, _) :-
    Beneficio = 'alto', Tiempo = 'varios_dias_semana'.
accion('consumir una dieta balanceada', Beneficio, _, Presupuesto) :-
    Beneficio = 'alto', Presupuesto >= 500.
accion('practicar meditación diariamente', Beneficio, Tiempo, _) :-
    Beneficio = 'alto', Tiempo = 'todos_los_dias'.
accion('mantener un horario regular de sueño', Beneficio, _, _) :-
    Beneficio = 'medio'.
accion('evitar el consumo excesivo de alcohol', Beneficio, _, _) :-
    Beneficio = 'medio'.
accion('dejar de fumar', Beneficio, _, _) :-
    Beneficio = 'alto'.
accion('realizar chequeos médicos regulares', Beneficio, _, _) :-
    Beneficio = 'medio'.
accion('buscar apoyo emocional cuando sea necesario', Beneficio, _, _) :-
    Beneficio = 'medio'.
accion('dedicar tiempo a actividades recreativas', Beneficio, Tiempo, _) :-
    Beneficio = 'bajo', Tiempo = 'ocasionalmente'.


salud_bienestar(Accion) :-
    write('¿Cuál es tu objetivo de bienestar? (alto, medio, bajo): '),
    read(Beneficio),
    write('¿Cuántos días a la semana tienes para dedicar a estas actividades? '),
    read(Tiempo),
    write('¿Cuánto estás dispuesto a gastar en estas acciones? (en pesos): '),
    read(Presupuesto),
    write('Basado en tus respuestas, te recomendamos las siguientes acciones para mejorar tu bienestar: '),
    accion(Accion, Beneficio, Tiempo, Presupuesto).


