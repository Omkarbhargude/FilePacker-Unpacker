# 📦 FilePacker-Unpacker
- A **Java-based file utility tool** that allows packing multiple files into a single archive and unpacking them back with all metadata preserved.  
- To enhance security, the packed file is **encrypted**, and only authorized users can decrypt and extract the data.  
- The project also features a **Swing-based GUI** for easy and user-friendly interaction.

---

## 🚀 Features

* **File Packing** – Combines multiple regular files into a single archive.
* **File Unpacking** – Restores original files and metadata from the packed archive.
* **Encryption** – Built-in XOR-based encryption & decryption for data security.
* **Graphical User Interface (GUI)** – Simple Swing-based UI for packing/unpacking.
* **Cross-Platform** – Works on any system with Java Runtime Environment (JRE).

---

## 🖼 Screenshots

| Packing Window | Packing Activity| Unpacking Activity|
|----------------|----------------|-----------------|
| ![Packing Window](https://github.com/Omkarbhargude/FilePacker-Unpacker/blob/main/images/PackingWindow.png?raw=true) | ![Packing Example](https://github.com/Omkarbhargude/FilePacker-Unpacker/blob/main/images/Packing.png?raw=true) | ![Unpacking Example](https://github.com/Omkarbhargude/FilePacker-Unpacker/blob/main/images/Unpacking.png?raw=true) |

---

## 🛠 Tech Stack

* **Java 17+**
* **Swing (GUI)**
* **Java I/O Streams**

---

## 📂 Project Structure

```
FilePacker-Unpacker/
├── src/FilePackerUnpacker/
│   ├── FilePacker.java
│   ├── FileUnpacker.java
│   └── GUI.java
└── screenshots/
    ├── main_window.png
    ├── packing_example.png
    └── unpacking_example.png
```

---

## ⚙️ Installation & Usage

### Clone the Repository

```bash
git clone https://github.com/OmkarBhargude/FilePacker-Unpacker.git
cd FilePacker-Unpacker/src
```

### Compile & Run (Source Code)

```bash
javac FilePackerUnpacker/*.java
java FilePackerUnpacker.GUI
```

---

## 🎓 Learning Outcomes

* Practical experience with **Java I/O Streams** and file handling.
* Implementation of **metadata management** in file operations.
* Understanding of **encryption/decryption** techniques in Java.
* Hands-on experience with **Swing GUI development**.

---

## 🔮 Future Improvements

* Add support for drag-and-drop in GUI.
* Stronger encryption methods (AES instead of XOR).
* Multi-threading for faster packing/unpacking.
* Cloud integration for remote file storage.

---

## 👨‍💻 Author

**Omkar Mahadev Bhargude**
📌 [LinkedIn](https://www.linkedin.com/in/omkar-bhargude-609a92311/)

