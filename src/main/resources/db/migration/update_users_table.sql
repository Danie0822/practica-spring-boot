-- Eliminar la restricción UNIQUE en el campo email
ALTER TABLE users DROP CONSTRAINT IF EXISTS users_email_key;

-- Agregar el campo deletedAt para el soft delete
ALTER TABLE users ADD COLUMN deletedAt TIMESTAMP NULL;

-- Agregar el campo createdAt con valor por defecto (fecha de creación)
ALTER TABLE users ADD COLUMN createdAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;

-- Agregar el campo updatedAt con valor por defecto (fecha de última actualización)
ALTER TABLE users ADD COLUMN updatedAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;
