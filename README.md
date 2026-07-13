# SlimeTinker Drake

<p>
  <a href="https://github.com/DrakesCraft-Labs/SlimeTinker-drake/actions"><img src="https://img.shields.io/github/actions/workflow/status/DrakesCraft-Labs/SlimeTinker-drake/drake-ci.yml?branch=1.21-latin&label=CI&style=flat-square" alt="CI"/></a>
  <img src="https://img.shields.io/badge/Minecraft-1.21.11-6d28d9?style=flat-square" alt="Minecraft 1.21.11"/>
  <img src="https://img.shields.io/badge/Java-21-f89820?style=flat-square" alt="Java 21"/>
  <img src="https://img.shields.io/badge/Slimefun-Drake%2011-581c87?style=flat-square" alt="Slimefun Drake 11"/>
</p>

SlimeTinker Drake amplía Slimefun con herramientas y armaduras construidas por
partes, materiales y rasgos. Es la edición mantenida para DrakesCraft: conserva
la experiencia tinker existente y moderniza el runtime sin convertir una
actualización en una migración de inventarios.

## Runtime compatible

| Componente | Objetivo |
|---|---|
| Minecraft / Paper / Purpur | **1.21.11** |
| Java | **21** |
| Slimefun | **Slimefun Drake 11** |
| API de compilación | `paper-api 1.21.1-R0.1-SNAPSHOT` |

La dependencia Maven de Paper sigue la línea API `1.21.1`; el addon se compila
contra Slimefun Drake 11 y está destinado al servidor 1.21.11. Esa diferencia
de nomenclatura no implica que el addon requiera un runtime anterior.

## Qué aporta

| Sistema | Función |
|---|---|
| Materiales y traits | Cada componente puede aportar propiedades que definen el resultado final. |
| Partes y moldes | Cabezas, mangos, placas, herramientas y armaduras se fabrican de forma modular. |
| Estaciones | Tool Table, Armour Table, Modification Station, Repair Bench, Smeltery y Workbench. |
| Integraciones | Materiales para Slimefun y addons compatibles cuando están instalados. |
| Progresión | Modificaciones, reparaciones, fundición, aleaciones y builds especializados. |

## Trabajo Drake

- Repositorio independiente, build reproducible y release identificable `1.2.1-Drake`.
- Migración de imports al stack Dough/Slimefun relocalizado de Drake.
- Retiro del autoactualizador heredado: no hay descargas de JAR en caliente.
- Corrección de iteración de estelas y de efectos Paper en transición de API.
- Límites configurables para tareas periódicas de rasgos y partículas, evitando trabajo ilimitado por jugador.
- Compatibilidad defensiva cuando faltan ítems o integraciones opcionales.

## Rendimiento y configuración

`plugins/SlimeTinker/config.yml` permite regular el trabajo recurrente sin
cambiar código:

| Ajuste | Default | Rango validado |
|---|---:|---:|
| `runtime.effect-tick-period` | 40 ticks | 20-200 |
| `runtime.trail-tick-period` | 5 ticks | 1-100 |
| `runtime.trail-particles-per-player` | 11 | 0-24 |

Los valores inválidos se sustituyen por defaults seguros durante el arranque.
Aplica los cambios en una ventana de reinicio programada.

## Compatibilidad de datos y actualización

SlimeTinker mantiene sus IDs, formato de `traits.yml`, materiales, partes y
claves PDC existentes. Antes de actualizar, respalda:

```text
plugins/SlimeTinker v1.2.DEV.jar
plugins/SlimeTinker/
```

Instala un único JAR de SlimeTinker, conserva el anterior como rollback y,
después del reinicio, valida una herramienta legacy con trait y una estela antes
de anunciar el cambio.

## Build

```bash
mvn -B -ntp clean verify
```

Artefacto: `target/SlimeTinker v1.2.1-Drake.jar`.

## Procedencia

Este repositorio conserva el historial del módulo extraído del monorepo
DrakesCraft. El trabajo Drake se limita a compatibilidad, estabilidad,
observabilidad operativa y mantenimiento sostenible del addon.
