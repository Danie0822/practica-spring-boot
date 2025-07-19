# Script PowerShell para probar la API de usuarios

Write-Host "=== Probando API de Usuarios ===" -ForegroundColor Green

# 1. Crear un usuario
Write-Host "1. Creando usuario..." -ForegroundColor Yellow
$body = @{
    email = "test@example.com"
    password = "password123"
    name = "Test User"
    age = 25
} | ConvertTo-Json

try {
    $response = Invoke-RestMethod -Uri "http://localhost:8080/api/users" -Method POST -Body $body -ContentType "application/json"
    $response | ConvertTo-Json -Depth 3
} catch {
    Write-Host "Error creando usuario: $_" -ForegroundColor Red
}

Write-Host ""

# 2. Obtener todos los usuarios
Write-Host "2. Obteniendo todos los usuarios..." -ForegroundColor Yellow
try {
    $response = Invoke-RestMethod -Uri "http://localhost:8080/api/users" -Method GET
    $response | ConvertTo-Json -Depth 3
} catch {
    Write-Host "Error obteniendo usuarios: $_" -ForegroundColor Red
}

Write-Host ""
Write-Host "=== Fin de las pruebas ===" -ForegroundColor Green
