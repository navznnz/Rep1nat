-- =======================
-- CREACIÓN DE TABLAS
-- =======================

-- Tabla CLIENTES
CREATE TABLE CLIENTES (
    IdCliente INT PRIMARY KEY,
    Nombre VARCHAR(50) NOT NULL,
    Apellido VARCHAR(50) NOT NULL,
    Email VARCHAR(100) UNIQUE
);

-- Tabla HABITACIONES
CREATE TABLE HABITACIONES (
    NumeroHabitacion INT PRIMARY KEY,
    Tipo VARCHAR(30) NOT NULL,
    PrecioPorNoche DECIMAL(10,2) NOT NULL,
    Capacidad INT NOT NULL
);

-- Tabla RESERVAS
CREATE TABLE RESERVAS (
    IdReserva INT PRIMARY KEY,
    FechaEntrada DATE NOT NULL,
    FechaSalida DATE NOT NULL,
    NumeroHuespedes INT NOT NULL,
    IdCliente INT NOT NULL,
    CONSTRAINT fk_reserva_cliente FOREIGN KEY (IdCliente)
        REFERENCES CLIENTES(IdCliente)
);

-- Tabla ASIGNACION_HABITACIONES (relación M:N entre RESERVAS y HABITACIONES)
CREATE TABLE ASIGNACION_HABITACIONES (
    IdReserva INT NOT NULL,
    NumeroHabitacion INT NOT NULL,
    CostoTotal DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (IdReserva, NumeroHabitacion),
    CONSTRAINT fk_asignacion_reserva FOREIGN KEY (IdReserva)
        REFERENCES RESERVAS(IdReserva),
    CONSTRAINT fk_asignacion_habitacion FOREIGN KEY (NumeroHabitacion)
        REFERENCES HABITACIONES(NumeroHabitacion)
);
