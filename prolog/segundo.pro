% OBJETIVO
% - Representar Startups Tecnologicas
% - Relacionar especialistas y tecnologias
% - Inferir perfiles estretegicos
% - Recomendar colaboraciones
% - Detectar empresas innovadoras
% - Aplicar reglas sencillas y complejas que generen nuevo conocimiento

% ============= HECHOS =============
% Interpretacion: existe una startup que se llama innovacion dudosa (x) 
startup(innovaciondudosa).
startup(leppe).
startup(lotus).
startup(rebonet).
startup(luzmaya).
startup(smartguide).
startup(laika).
startup(centinela).

usa_tecnologia(innovaciondudosa, agente_IA).
usa_tecnologia(innovaciondudosa, agente_IA).
usa_tecnologia(innovaciondudosa, base_de_datos).
usa_tecnologia(leppe, tecnologia_emergente).
usa_tecnologia(leppe, inteligencia_artificial).
usa_tecnologia(leppe, vision_computacional).
usa_tecnologia(lotus, redes_neuronales).
usa_tecnologia(lotus, vision_computacional).
usa_tecnologia(lotus, inteligencia_artificial).
usa_tecnologia(rebonet, industria_pecuaria).
usa_tecnologia(rebonet, material_organico).
usa_tecnologia(luzmaya, energias_renovables).
usa_tecnologia(smartguide, iot).
usa_tecnologia(smartguide, industria40).
usa_tecnologia(laika, redes_neuronales).
usa_tecnologia(laika, vision_computacional).
usa_tecnologia(centinela, redes_neuronales).
usa_tecnologia(centinela, vision_computacional).

especialistas(luis, vision_computacional).
especialistas(luis, inteligencia_artificial).
especialistas(emilio, vision_computacional).
especialistas(emilio, inteligencia_artificial).
especialistas(emilio, redes_neuronales).
especialistas(emilio, repositorios).
especialistas(brian, inteligencia_artificial).
especialistas(teresa, iot).
especialistas(teresa, industria40).
especialistas(rene, energias_renovables).
especialistas(rene, iot).

inversion_economica(leppe).
inversion_economica(rebonet).

%====================REGLAS=============================

startup_ia(X):-
    usa_tecnologia(X, inteligencia_artificial).

startup_exitosa(X):-
    usa_tecnologia(X, inteligencia_artificial),
    inversion_economica(X).

startup_sustentable(X):-
    usa_tecnologia(X, energias_renovables);
    usa_tecnologia(X, material_organico).

startup_futurista(X):-
    usa_tecnologia(X, inteligencia_artificial),
    usa_tecnologia(X, vision_computacional).
    
colaborador_ideal(Persona, Startup):-
    especialistas(Persona, Tecnologia),
    usa_tecnologia(Startup, Tecnologia).

ecosistema_avanzado(X):-
    usa_tecnologia(X, redes_neuronales),
    usa_tecnologia(X, vision_computacional).



    