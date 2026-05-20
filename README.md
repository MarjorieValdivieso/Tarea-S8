
# Sistema de Registro Académico en Java

Este proyecto es una aplicación de consola desarrollada en Java utilizando Programación Orientada a Objetos (POO). El sistema permite registrar estudiantes y docentes mediante operaciones CRUD usando ArrayList.

# Conceptos aplicados

Herencia
Se utilizó una clase padre llamada Persona y dos subclases:
- Estudiante
- Docente

Ambas heredan atributos y métodos de la clase principal.

# Encapsulamiento
Los atributos fueron protegidos usando modificadores de acceso y métodos get y set para manejar la información de forma segura.

# Polimorfismo
El método mostrarDatos() fue sobrescrito con @Override en cada subclase para mostrar información específica según el tipo de persona.

# CRUD
El sistema permite:
- Registrar personas
- Mostrar registros
- Actualizar información
- Eliminar registros

Todo esto se maneja con ArrayList.

# Validaciones
Se agregaron validaciones para:
- Evitar cédulas repetidas mediante un método de verificación
- Controlar errores de entrada
- Verificar campos vacíos
- Evitar posiciones inexistentes

Manejo de excepciones
Se utilizó try-catch con InputMismatchException para evitar que el programa se cierre por errores del usuario.
