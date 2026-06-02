# 🎹 Synthixel

Synthixel is a simple Java-based piano application built using Swing.  
It allows users to play piano notes using their keyboard with real-time visual feedback and sound playback.

---

## ✨ Features

- 🎹 Full playable piano (white + black keys)
- ⌨️ Keyboard mapping support
- 🔊 Real-time sound playback using WAV files
- 🖼️ Custom piano key sprites
- 🖥️ Simple GUI built with Java Swing
- ⚡ Lightweight and fast (no external libraries)

---

## 🎮 Controls

### White Keys
| Key | Note |
|-----|------|
| A | C |
| S | D |
| D | E |
| F | F |
| G | G |
| H | A |
| J | B |
| K | C2 |
| L | D2 |
| ; | E2 |

### Black Keys
| Key | Note |
|-----|------|
| W | C# |
| E | D# |
| T | F# |
| Y | G# |
| U | A# |
| O | C#2 |
| P | D#2 |

---

## 📁 Project Structure

```

src/
└── main/
├── Main.java
├── Synthixel.java
├── PianoPanel.java
├── PianoKeys.java
├── PianoInput.java
├── SoundManager.java

res/
├── sprite/
│    ├── white_key.png
│    └── black_key.png
└── sounds/
├── c1.wav
├── d1.wav
├── e1.wav
├── f1.wav
├── g1.wav
├── a1.wav
├── b1.wav
├── c2.wav
├── d2.wav
├── e2.wav
├── c-sharp1.wav
├── d-sharp1.wav
├── f-sharp1.wav
├── g-sharp1.wav
├── a-sharp1.wav
├── c-sharp2.wav
└── d-sharp2.wav

````

---

## 🚀 How to Run

1. Clone the repository:
```bash
git clone https://github.com/your-username/synthixel.git
````

2. Open in Eclipse / IntelliJ / VS Code

3. Make sure `res/` folder is included in build path

4. Run:

```
Main.java
```

---

## 🛠️ Requirements

* Java 8 or higher
* Any Java IDE (Eclipse, IntelliJ, VS Code)

---

## 💡 Notes

* Sound files must be inside `/res/sounds/`
* Sprite images must be inside `/res/sprite/`
* Uses Java Swing (no external libraries)

---

## 👨‍💻 Author

Made by John Clark Melitar
Project: Synthixel 🎹

---

# 📜 LICENSE 

This project is licensed under the MIT License.  
See the [LICENSE](LICENSE) file for details.
