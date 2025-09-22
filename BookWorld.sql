
CREATE DATABASE BookWorld;
GO

USE BookWorld;
GO


CREATE SCHEMA Biblioteca;
GO
CREATE SCHEMA Autores;
GO


CREATE TABLE Biblioteca.Libros (
    IdLibro INT PRIMARY KEY,
    Titulo NVARCHAR(150),
    Precio MONEY,
    Stock INT,
    FechaPublicacion DATE,
    Categoria VARCHAR(50),
);
GO
INSERT INTO Biblioteca.Libros
    (IdLibro, Titulo, Precio, Stock, FechaPublicacion, Categoria)
VALUES
    (1, 'Cien Años de Soledad', 45.00, 3, '1967-05-30', 'Novela'),
    (2, 'El Principito',        25.00, 8, '1943-04-06', 'Infantil'),
    (3, 'Don Quijote',          55.00, 2, '1605-01-16', 'Clásico');
GO
CREATE TABLE Autores.Autores (
    IdAutor INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Nacionalidad VARCHAR(50),
    FechaNacimiento DATE
);
GO


ALTER TABLE Biblioteca.Libros
ADD Categoria VARCHAR(50);
GO

DECLARE @StockCritico INT;
SET @StockCritico = 5;

SELECT *
FROM Biblioteca.Libros
WHERE Stock < @StockCritico;
GO


TRUNCATE TABLE Biblioteca.Libros;
GO


EXEC sp_rename 'Autores.Autores', 'Escritores';
GO


DROP TABLE Biblioteca.Libros;
GO
CREATE DATABASE BookWorld;
GO

USE BookWorld;
GO


CREATE SCHEMA Biblioteca;
GO
CREATE SCHEMA Autores;
GO


CREATE TABLE Biblioteca.Libros (
    IdLibro INT PRIMARY KEY,
    Titulo NVARCHAR(150),
    Precio MONEY,
    Stock INT,
    FechaPublicacion DATE,
    Categoria VARCHAR(50),
);
GO
INSERT INTO Biblioteca.Libros
    (IdLibro, Titulo, Precio, Stock, FechaPublicacion, Categoria)
VALUES
    (1, 'Cien Años de Soledad', 45.00, 3, '1967-05-30', 'Novela'),
    (2, 'El Principito',        25.00, 8, '1943-04-06', 'Infantil'),
    (3, 'Don Quijote',          55.00, 2, '1605-01-16', 'Clásico');
GO
CREATE TABLE Autores.Autores (
    IdAutor INT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Nacionalidad VARCHAR(50),
    FechaNacimiento DATE
);
GO


ALTER TABLE Biblioteca.Libros
ADD Categoria VARCHAR(50);
GO

DECLARE @StockCritico INT;
SET @StockCritico = 5;

SELECT *
FROM Biblioteca.Libros
WHERE Stock < @StockCritico;
GO


TRUNCATE TABLE Biblioteca.Libros;
GO


EXEC sp_rename 'Autores.Autores', 'Escritores';
GO


DROP TABLE Biblioteca.Libros;
GO
