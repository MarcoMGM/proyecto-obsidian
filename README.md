# Proyecto Obsidian - Tienda de Joyas

## Integrantes
- Marco González

## Descripción
Sistema de microservicios para la gestión de una tienda de joyas, desarrollado con Spring Boot 3.5 y MySQL.

## Microservicios
- service-usuarios (puerto 8081): gestión de clientes y tipos de cliente
- service-productos (puerto 8082): catálogo de joyas y categorías
- service-inventario (puerto 8083): stock y movimientos de inventario
- service-pagos (puerto 8084): órdenes de pago y procesamiento
- service-logistica (puerto 8085): envíos y seguimiento
- api-gateway (puerto 8080): punto de entrada único

## Requisitos
- Java 21 o superior
- MySQL (XAMPP)
- Maven

## Pasos para ejecutar
1. Iniciar XAMPP con Apache y MySQL
2. Crear las bases de datos: db_usuarios, db_productos, db_inventario, db_pagos, db_logistica
3. Ejecutar cada microservicio con: .\mvnw.cmd spring-boot:run
4. El API Gateway se inicia en el puerto 8080
