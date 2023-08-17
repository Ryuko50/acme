# Microservicio pruebas ACME

Para este proyecto de microservicio se va a poner en práctica todo lo aprendido sobre **desarrollo backend** con Spring Boot hasta ahora. El principal objetivo será proporcionar una API funcional que crezca de forma evolutiva, siguiendo los diferentes requerimiento que vayan surgiendo (uso de metodología ágil).

## Gestión del proyecto
Vamos a hacer uso de las herramientas de gestión que proporciona GitHub para este proyecto. Para ver una guía más detallada de como usar Projects o Issues, revisar el [README.md](https://github.com/Yerehia/test_exercises) del anterior proyecto de pruebas.

## Metodología del proyecto
Como he descrito, se va a emplear el uso de metodologías ágiles (SCRUM). En principio vamos a hacer una variación, ya que es un poco "de mentira". Además, el objetivo no es solo el desarrollo de un API, sino también empezar a profundizar en el diseño, lo que ayudará a asentar mejor los conceptos de desarrollo de microservicios.

### 1. Análisis del pliego
Lo primero que se obtendrá en cada "iteración", es un pliego, donde se detallarán los requisitos funcionales. Los requisitos funcionales habitualmente se recogen durante la entrevista con el cliente, y no en forma de requisito sino de "historias de usuario" (no entremos en terminología). Al final lo que recogeremos en el pliego es todo lo que queremos que nuestro microservicio haga a alto nivel, y ese "requisito" se va desgranando hasta elaborar issues y un modelo.

### 2. Elaboración del modelo
Una vez analizado todos nuetsros requerimientos, detectaremos ciertos "objetos" que querremos modelar. Por ejemplo, si tenemos un requisito que sea que "el usuario pueda hacer login en la página usando usuario y contraseña", ya podemos descubrir que "Usuario" será una entidad que tendrá *mínimo* los atributos "usuario" y "contraseña".

Cuando elaboramos el modelo, no nos referimos a empezar a picar las entidades, sino a pensar como son y como se relacionan. Si también encontramos el requisito "el usuario podrá tener el rol de administrador, cliente o sponsor", nos daremos cuenta de que un usuario puede ser de diferentes tipos ¿como gestionamos esta relación? Este es el tipo de problemáticas que iremos encontrando a la hora de elaborar el modelo.

Ya que al final esto es un pensamiento algo más *abstracto*, normalmente estas ideas se plasman a través de diagramas UML. No es común tener que diseñar un diagrama UML a nivel profesional, pero es MUY IMPORTANTE saber interpretarlos. Mi objetivo es que aprendas a interpretar y que también puedas confeccionar, ya que esto otorga mucho valor a un profesional.

### 3. Creación y priorización de las tareas
Además de obtener el modelo, del pliego también sacaremos las diferentes issues. Vamos a retomar el ejemplo de "el usuario pueda hacer login en la página usando usuario y contraseña", y vamos a analizar que "tarea vamos a tener que realizar". 
Nuestro microservicio deberá tener un **endpoint** que nos permita hacer login, por lo tanto vamos a necesitar desarrollar este endpoint y esto conllevará la creación de una "issue". Esta issue podrá ser más o menos detallada, pero es importante poner como de grande va a ser, por ello, hay que ver todo lo que conllevaría a nivel de código:

El endpoint será de tipo POST, porque no queremos obtener información sino mandarla a través del body, y como vamos a mandar usuario y contraseña, mandaremos una entidad que tenga esos dos parámetros. Una vez el microservicio los reciba, deberá revisar si el usuario existe y si la contraseña coincide (obviamente esto desde el servicio). Si el usuario se loga, finalmente se redirigirá a una página en concreto o se hará x o y acción, según se indique en el pliego.

Una vez tenemos esta issue, pasaríamos a analizar cuantas más tenemos y las dejaremos en el backlog (usando la herramienta Projects).

### 4. Realización de las tareas
Ya este sería el último punto, que al final es el propio desarrollo de las tareas que hemos ido desgranando.


## Diagrama de clases
Cuando hablo de UML en la elaboración de modelo, me refiero a diagramas de este tipo:

![image](https://github.com/Ryuko50/acme/assets/43781686/43c1062c-7c58-4bb5-bffe-0e6bd78528cb)

Básicamente esto nos ayuda a identificar las entidades y como se relacionan. En este caso, vemos un ejemplo de herencia, ya que un usuario puede ser de tipo administrador o cliente según el diagrama expuesto (la flecha blanca es la que indica esa herencia).

![image](https://github.com/Ryuko50/acme/assets/43781686/b3718efc-df29-414f-abf5-11d27f49c082)

En este otro ejemplo se ve que 1 carrito de la compra (o ninguno, porque los productos pueden existir aunque no haya un carrito) puede tener varios productos o estar vacío (0..*).

https://online.visual-paradigm.com/


Esto sería todo, ya solo queda empezar a revisar los pliegos e ir haciendo los pasos.
