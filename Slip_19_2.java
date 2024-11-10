// Q.2 Start Raspberry Pi and Execute various Linux commands in command
// terminal window: ls, cd, touch, mv, rm, man, mkdir, rmdir, tar, gzip, cat,
// more, less, ps, sudo, cron, chown, chgrp, pingetc.

public class Slip_19_2 {
    
}

/*To execute the various Linux commands on a **Raspberry Pi** using the command terminal window, follow the instructions below for each command. These commands allow you to manage files, directories, processes, and more on your Raspberry Pi running Linux (Raspbian OS or any Linux-based distribution).

### 1. **`ls` (List files and directories)**
   - List files and directories in the current directory:
   ```bash
   ls
   ```
   - List all files (including hidden files):
   ```bash
   ls -a
   ```
   - List files with detailed information:
   ```bash
   ls -l
   ```

### 2. **`cd` (Change Directory)**
   - Change to a specific directory:
   ```bash
   cd /path/to/directory
   ```
   - Go back to the home directory:
   ```bash
   cd
   ```
   - Go up one directory level:
   ```bash
   cd ..
   ```

### 3. **`touch` (Create a new empty file)**
   - Create a new empty file:
   ```bash
   touch filename.txt
   ```

### 4. **`mv` (Move or rename files)**
   - Rename a file:
   ```bash
   mv oldname.txt newname.txt
   ```
   - Move a file to a different directory:
   ```bash
   mv file.txt /path/to/destination/
   ```

### 5. **`rm` (Remove files or directories)**
   - Remove a file:
   ```bash
   rm filename.txt
   ```
   - Remove a directory (with `-r` for recursive deletion):
   ```bash
   rm -r directory_name
   ```
   - Force remove files or directories without prompting:
   ```bash
   rm -rf directory_name
   ```

### 6. **`man` (Manual pages for a command)**
   - Display the manual for a command (e.g., `ls`):
   ```bash
   man ls
   ```

### 7. **`mkdir` (Make a new directory)**
   - Create a new directory:
   ```bash
   mkdir directory_name
   ```

### 8. **`rmdir` (Remove an empty directory)**
   - Remove an empty directory:
   ```bash
   rmdir directory_name
   ```

### 9. **`tar` (Archive files)**
   - Create a `.tar` archive of a directory:
   ```bash
   tar -cvf archive_name.tar directory_name
   ```
   - Extract files from a `.tar` archive:
   ```bash
   tar -xvf archive_name.tar
   ```

### 10. **`gzip` (Compress files)**
   - Compress a file using gzip:
   ```bash
   gzip filename.txt
   ```
   - Extract a `.gz` file:
   ```bash
   gunzip filename.txt.gz
   ```

### 11. **`cat` (Concatenate and display file content)**
   - Display the content of a file:
   ```bash
   cat filename.txt
   ```

### 12. **`more` (View file content with pagination)**
   - View a file one page at a time:
   ```bash
   more filename.txt
   ```

### 13. **`less` (View file content with better navigation)**
   - View a file (with forward and backward navigation):
   ```bash
   less filename.txt
   ```

### 14. **`ps` (View running processes)**
   - Show running processes:
   ```bash
   ps
   ```
   - Show all processes running on the system:
   ```bash
   ps aux
   ```

### 15. **`sudo` (Run commands with superuser privileges)**
   - Run a command with administrative privileges (e.g., update system):
   ```bash
   sudo apt update
   ```

### 16. **`cron` (Schedule jobs to run at specific times)**
   - Open the crontab editor to schedule jobs:
   ```bash
   crontab -e
   ```
   - View scheduled cron jobs:
   ```bash
   crontab -l
   ```
   - Example cron job to run a script every day at 3 PM:
   ```bash
   0 15 * * * /path/to/script.sh
   ```

### 17. **`chown` (Change file owner)**
   - Change the ownership of a file or directory:
   ```bash
   sudo chown user:group filename.txt
   ```

### 18. **`chgrp` (Change group ownership)**
   - Change the group ownership of a file or directory:
   ```bash
   sudo chgrp group_name filename.txt
   ```

### 19. **`ping` (Test network connectivity)**
   - Ping a host (e.g., Google's DNS):
   ```bash
   ping 8.8.8.8
   ```
   - Ping a domain name (e.g., `google.com`):
   ```bash
   ping google.com
   ```
   - Stop the pinging with `Ctrl+C`.

### **Additional Tips**:
- **Autocompletion**: Press **Tab** to auto-complete file or directory names.
- **Clear terminal screen**: Type `clear` to clear the terminal window.
- **Help with commands**: Most commands provide a help option. For example, `ls --help` or `man ls`.

These commands are essential for navigating and managing your Raspberry Pi, and they are part of the standard Linux command set. You can use them to interact with the file system, manage processes, and configure your system. */