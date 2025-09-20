# Random Maze Generator (Java)

This repository contains a **Java-based random maze generator** that creates mazes of customizable size, generates paths, and allows users to choose the entry and exit positions. The maze is displayed directly in the console using ASCII characters.

---

## 🛠️ Features

- Random maze generation with adjustable width and height  
- Path generation algorithm ensuring connected and traversable mazes  
- User-defined or random **start (S)** and **finish (F)** positions  
- Visual output in console using ASCII characters (`█` for walls, spaces for paths)  
- Input validation to ensure proper maze dimensions and choices

---

## 🚀 How to Run

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/maze-generator.git
   cd maze-generator
   ```

2. **Compile and run**  
   - 🐧 On WSL / Linux / macOS:  
    
    Run the provided run.sh script `run.sh`  
    ```bash
     ./run.sh
    ```

    - 🪟 On Windows:  

    Run the provided `run.bat` script (**double-click** or execute from terminal):
    ```bat
    run.bat
    ```
3. Follow prompts
   - Enter the maze width and height (minimum 3)
   - Select the entry/exit positioning mode:
     1. Start on a border, end inside the maze
     2. Start and end on random borders
     3. Start and end at opposite borders

4. Enjoy the generated maze
   - S marks the start
   - F marks the finish
   - Walls are displayed as solid blocks █
