# ConnectMSG

A lightweight BungeeCord plugin that allows you to customize the default "You are already connecting to this server" message with your own personalized text.

## 🌟 Features

- ✅ **Customizable Message**: Replace the boring default connection message with your own text
- ✅ **Color Support**: Full support for Minecraft color codes (`&a`, `&c`, `&l`, etc.)
- ✅ **Server Placeholder**: Use `%server%` to display the target server name
- ✅ **Lightweight**: Minimal resource usage and fast performance
- ✅ **Easy Configuration**: Simple YAML configuration file
- ✅ **Admin Commands**: `/cmsg reload` and `/cmsg help` commands
- ✅ **Permission System**: `connectmsg.admin` permission for command access

## 📋 Requirements

- **BungeeCord** proxy server
- **Java 8** or higher
- This plugin is **BungeeCord only** - it does not work with Paper/Spigot servers

## 🚀 Installation

1. Download the `ConnectMSG.jar` file from the releases
2. Place the file in your **BungeeCord plugins folder**
3. Restart or reload your BungeeCord proxy
4. Edit the generated `config.yml` file in `plugins/ConnectMSG/`
5. Run `/cmsg reload` to apply your changes

## ⚙️ Configuration

After the first launch, a `config.yml` file will be created in `plugins/ConnectMSG/`.

### Default Configuration:
```yaml
# Here you can set the connection message.
# Placeholder(s):
# %server% = Servername you are attempting to connect to.
message: "&b&l(%server%) &r&7You are already connecting to this server!"
```

### Color Codes
Use standard Minecraft color codes with the `&` symbol:
- `&0` - Black
- `&1` - Dark Blue  
- `&2` - Dark Green
- `&3` - Dark Aqua
- `&4` - Dark Red
- `&5` - Dark Purple
- `&6` - Gold
- `&7` - Gray
- `&8` - Dark Gray
- `&9` - Blue
- `&a` - Green
- `&b` - Aqua
- `&c` - Red
- `&d` - Light Purple
- `&e` - Yellow
- `&f` - White
- `&l` - Bold
- `&m` - Strikethrough
- `&n` - Underline
- `&o` - Italic
- `&r` - Reset

### Placeholders
- `%server%` - The name of the server the player is trying to connect to

## 🎮 Commands

| Command | Description | Permission |
|---------|-------------|------------|
| `/cmsg help` | Show help information | `connectmsg.admin` |
| `/cmsg reload` | Reload the configuration file | `connectmsg.admin` |

## 🔒 Permissions

- `connectmsg.admin` - Required to use plugin commands

## 📸 Before & After

### ❌ Before (Default BungeeCord Message)
```
You are already connecting to this server!
```

### ✅ After (Custom Message Example)
```
(Lobby) You are already connecting to this server!
```

## ❓ FAQ

**Q: Does this work with Paper/Spigot?**  
A: No, this plugin is designed specifically for **BungeeCord proxy servers only**.

**Q: Can I use hex color codes?**  
A: Currently, only traditional `&` color codes are supported. Hex color support may be added in future updates.

**Q: How do I reload the config without restarting?**  
A: Use the `/cmsg reload` command (requires `connectmsg.admin` permission).

**Q: Can I use multiple lines in the message?**  
A: The plugin is designed for single-line messages. Multi-line support is not currently available.

## 🐛 Support & Issues

Having problems or want to suggest a feature? 

- **GitHub Issues**: [Open an issue](https://github.com/sheet315/connectmessage/issues)
- **Source Code**: [View on GitHub](https://github.com/sheet315/connectmessage)

## 🤝 Contributing

Contributions are welcome! Feel free to:
- Report bugs
- Suggest new features  
- Submit pull requests
- Improve documentation

## 📜 License

This project is open source. Check the repository for license details.

## ❤️ Support the Developer

If you find this plugin useful:
- ⭐ Star the GitHub repository
- 💬 Leave a review on SpigotMC
- 🐛 Report bugs to help improve the plugin
- 💡 Suggest new features
