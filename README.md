# SlimeTinker-drake

[![Rama](https://img.shields.io/badge/branch-1.21--latin-2ea44f)](https://github.com/DrakesCraft-Labs/SlimeTinker-drake/tree/1.21-latin)
[![Licencia](https://img.shields.io/github/license/DrakesCraft-Labs/SlimeTinker-drake)](https://github.com/DrakesCraft-Labs/SlimeTinker-drake/blob/1.21-latin/LICENSE)
[![Ultimo commit](https://img.shields.io/github/last-commit/DrakesCraft-Labs/SlimeTinker-drake/1.21-latin)](https://github.com/DrakesCraft-Labs/SlimeTinker-drake/commits/1.21-latin)

## Descripción técnica
Addon de materiales y rasgos tipo tinker para herramientas/armaduras dentro de Slimefun.

## Qué añade a Slimefun
- Profundiza personalización de equipamiento en Slimefun.
- Introduce metajuego de builds por rasgos/materiales.
- Habilita progresión modular de herramientas y armaduras.

## Características principales
- Sistema de materiales con traits por componente.
- Combinaciones de partes para herramientas personalizadas.
- Compatibilidad endurecida ante ítems opcionales faltantes.

## Matriz de compatibilidad
| Componente | Estado |
|---|---|
| Minecraft | 1.21.x |
| Paper/Purpur | 1.21.x |
| Slimefun Core Drake | 11.x (línea `1.21-latin`) |
| Java | 21 |

## Instalación
1. Descarga el `.jar` de Releases del repositorio.
2. Copia el archivo en la carpeta `plugins/` del servidor.
3. Asegura dependencias (`Slimefun`, `ProtocolLib` u otras según addon).
4. Reinicia el servidor y revisa `logs/latest.log` para validar carga.

## Build local
```bash
mvn -DskipTests clean package
```

Artefacto esperado:
- `target/SlimeTinker*.jar`

## Flujo de release
1. Crear branch de cambios (`feature/*` o `fix/*`).
2. Abrir PR hacia `1.21-latin` con plan de pruebas.
3. Al mergear, crear tag/release y publicar jar compilado.

Mantener changelog de materiales/traits y validar registros contra addons opcionales.

## Relación con el monorepo
Este repositorio se mantiene en paralelo con `drakes-slimefun-labs` para desarrollo aislado por addon y despliegues independientes.