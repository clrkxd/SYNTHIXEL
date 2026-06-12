# 🎹 Synthixel

Synthixel is a simple Java-based piano application built using Swing. <br>
Inspired by many virtual piano music software, Synthixel allows users to play piano notes using their keyboard with real-time visual feedback and sound playback.

---

## ✨ Features

- 🎹 Full playable piano (white + black keys)
- 🎵 Different Instruments (Piano, Organ, Strings, Guitar)
- 💻 Fully customizable open-source project
- ⌨️ Keyboard mapping support
- 🔊 Real-time sound playback using WAV files
- 🖼️ Custom piano key sprites made using Aseprite
- 🖥️ Simple GUI built with Java Swing
- ⚡ Lightweight and fast (no external libraries)

---

## 🎮 How to Play

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

## 🎮 How to make the buttons function

### Black Keys
| Control | KeyCode | Function |
|-----|------|------|
| ↑ | VK.UP | Volume Up |
| ↓ | VK.DOWN | Voulme Down |
| S | VK.SPACE | Sustain |
| ← | VK.LEFT | Instrument Switch |
| → | VK.RIGHT | Instrument Switch |

---

## 📁 Project Structure

```
src/
├── audio/
│    ├── InstrumentManager.java
│    ├── Instruments.java
│    └── SoundManager.java
├── input/
│    └── PianoInput.java
├── main/
│    └── Synthixel.java
├── record/
│    ├── NoteEvent.java
│    └── Recorder.java
├── save/
│    └── SaveManager.java
└── ui/
     ├── PianoPanel.java
     ├── PianoKeys.java
     ├── ButtonLayer.java
     ├── PianoButton.java
     ├── PianoFrameLayer.java
     ├── PianoLinesLayer.java
     ├── UIConstants.java
     └── VolumeLayer.java
````
````
res/
├── font/
│    └── VT323-Regular.ttf
├── sprite/
│    ├── white_key.png
│    ├── black_key.png
│    ├── synthixel_appicon.png
│    ├── darkmode.png
│    ├── left.png
│    ├── monitor.png
│    ├── piano-frame.png
│    ├── piano-lines.png
│    ├── play.png
│    ├── record.png
│    ├── right.png
│    ├── save.png
│    ├── stop.png
│    ├── sustain.png
│    └── vol.png
├── piano/
│    ├── c1.wav
│    ├── d1.wav
│    ├── e1.wav
│    ├── f1.wav
│    ├── g1.wav
│    ├── a1.wav
│    ├── b1.wav
│    ├── c2.wav
│    ├── d2.wav
│    ├── e2.wav
│    ├── c-sharp1.wav
│    ├── d-sharp1.wav
│    ├── f-sharp1.wav
│    ├── g-sharp1.wav
│    ├── a-sharp1.wav
│    ├── c-sharp2.wav
│    └── d-sharp2.wav
├── organ/
├── guitar/
└── strngs/
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
Synthixel.java
```

or

```
Get a copy of the release of the current alpha version.
Synthixel_(version)-alpha.jar
```

---

## 🛠️ Requirements

* Java 17 or higher
* Any Java IDE (Eclipse, IntelliJ, VS Code)

---

## 💡 Notes

* Sound files must be inside `/res/(name of instrument)/`
* Sprite images must be inside `/res/sprite/`
* Uses Java Swing (no external libraries)
* Alpha releases are still going on

<br>

> THIS PROJECT IS STILL UNDER DEVELOPMENT. <br>
> SUGGESTIONS ARE HIGHLY RECOMMENDED. <br>
> PLEASE SUPPORT MY PROJECT AND GIVE IT A TRY.

---

## 👨‍💻 Author

Made by John Clark Melitar <br>
Project: Synthixel 🎹

---

# 📜 LICENSE 

This project is licensed under the MIT License.  
See the [LICENSE](LICENSE) file for details.
