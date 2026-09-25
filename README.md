<div align="center">

  <img src="https://raw.githubusercontent.com/DrakesCraft-Labs/SlimeTinker-drake/main/banner.svg" alt="SlimeTinker-drake Banner" width="920" />

# 🧪 SlimeTinker-Drake

**Slimefun4 Addon with Native Rust Acceleration (Java 21 Project Panama FFM API)**

<p>
  <a href="https://github.com/DrakesCraft-Labs/SlimeTinker-drake"><img src="https://img.shields.io/badge/GitHub-SlimeTinker--Drake-181717?style=for-the-badge&logo=github" alt="GitHub"/></a>
  <img src="https://img.shields.io/badge/Java-21_FFM_Panama-F89820?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java 21 FFM"/>
  <img src="https://img.shields.io/badge/Rust-FFM_Accelerated-FF4500?style=for-the-badge&logo=rust&logoColor=white" alt="Rust Native"/>
  <img src="https://img.shields.io/badge/Paper-1.21.11-38BDF8?style=for-the-badge&logo=minecraft&logoColor=white" alt="Paper 1.21.11"/>
</p>

[🇬🇧 **English**](README.md) · [🇪🇸 **Español**](README_ES.md)

</div>

> ### 🏰 Join the Official DrakesCraft Community!
> 
> * 🎮 **Server IP**: `mc.drakescraft.cl` *(Java 1.21.11 & Bedrock Port 25565 / 19132)*
> * 💬 **Official Discord**: [discord.gg/drakescraft](https://discord.gg/rv3vtXZTk7) — *Check out `#general-english`!*
> * 🌐 **Website & Guides**: [web.drakescraft.cl](https://web.drakescraft.cl) — 🛒 **Store**: [web.drakescraft.cl/store](https://web.drakescraft.cl/store.html)
> 
> *Play with this addon alongside 80+ optimized expansions live on our technical survival network!*

---

## ⚡ Zero-Risk Hybrid Engine Innovations

`SlimeTinker-Drake` integrates the Project Panama FFM component **`RustNativeBridge`** to offload machine tickers and intensive calculations directly to the native `Slimefun-Rust` engine (`slimefun_ffi`):
- 🚀 **Nanosecond Tick Processing**: Real CPU multi-threaded parallelism with zero Garbage Collector pauses.
- 🛡️ **Zero-Reset SQLite Safety**: Preserves all placed blocks and inventories in `stored-blocks.db` without data loss.

---

## 📖 Gameplay Features

Modular tool and armor system for Slimefun4, maintained and enhanced by DrakesCraft Labs.
Registers custom modular gear, parts, and modifiers in the Slimefun guide:

* All items are researched and crafted directly through the standard Slimefun Guide (`/sf guide`).
* No special commands required to get started.
* Modular tool assembly, material traits, and progressive modifier leveling.

---

## 📋 Compatibility

| Parameter | Requirement |
|---|---|
| **Server Software** | Paper / Purpur **1.21.11** |
| **Java Runtime** | **Java 21** LTS |
| **Required Core** | [Slimefun4-Drake](https://github.com/DrakesCraft-Labs/Slimefun4-Drake) |
| **Architecture** | Server-Side Only — players join with vanilla Minecraft clients |

---

## 📥 Installation

1. Download the latest `.jar` from the [Releases](https://github.com/DrakesCraft-Labs/SlimeTinker-drake/releases) page.
2. Place it into your server's `plugins/` directory alongside `Slimefun4-Drake.jar`.
3. Restart the server. Items and recipes will automatically appear in `/sf guide`.

> *Note: This addon is compiled for the DrakesCraft Slimefun fork. Compatibility with upstream legacy forks may require namespace adjustments.*

---

## 🛠️ Compilation

```bash
git clone https://github.com/DrakesCraft-Labs/SlimeTinker-drake.git
cd SlimeTinker-drake
mvn clean package
```

The output JAR will be generated under `target/SlimeTinker-drake.jar`.

---

<div align="center">

**DrakesCraft Labs** · Maintained by [**JackStar6677-1**](https://github.com/JackStar6677-1)

</div>

## ⚖️ Upstream Attribution & License

- **Original Project / Upstream**: Slimefun4 Community Addon (originally authored by Sefiraat).
- **Port & Maintenance**: DrakesCraft Labs team (Compatibility for Paper / Purpur 1.21.11 & Java 21 FFM).
- **License**: GNU General Public License v3.0 (GPL-3.0-only).
- **Source Code**: [GitHub Repository](https://github.com/DrakesCraft-Labs/SlimeTinker-drake)
- **Support & Issues**: [GitHub Issues](https://github.com/DrakesCraft-Labs/SlimeTinker-drake/issues) | [Discord](https://discord.gg/rv3vtXZTk7)

*This project is an open-source derivative work maintained by DrakesCraft Labs under the terms of its original license. See [docs/UPSTREAM_ATTRIBUTION.md](docs/UPSTREAM_ATTRIBUTION.md) for detailed upstream history.*
