// Q.2 Start Raspberry Pi and execute various Linux commands in command terminal window:
// ls, cd, touch, mv, rm, man, mkdir, rmdir, tar, gzip, cat, more, less, ps, sudo, cron, chown,
// chgrp, pingetc.
public class Slip_8_2 {
    
}
/*To start **Raspberry Pi** and execute various **Linux commands** in the command terminal, follow these steps. Make sure that your Raspberry Pi is set up and running with a Linux-based operating system, such as **Raspberry Pi OS** (formerly Raspbian).

### **Steps to Start Raspberry Pi and Execute Commands**:

1. **Booting the Raspberry Pi**:
   - Ensure that your **Raspberry Pi** is powered on, with an SD card that has Raspberry Pi OS installed.
   - Connect a keyboard, mouse, and monitor to the Raspberry Pi.
   - The Raspberry Pi should boot up and display the desktop environment. If you're using **Raspberry Pi OS Lite** (no GUI), it will boot directly to the terminal.

2. **Access the Command Line Terminal**:
   - If you're using the **desktop environment** (GUI), open a terminal by clicking on the terminal icon or pressing `Ctrl + Alt + T`.
   - If you're using the **Lite version** (without GUI), you will already be in the command line terminal.

3. **Executing Various Linux Commands**:
   Below are the descriptions and examples of the most commonly used Linux commands in the terminal:

### **Basic Linux Commands**:

1. **`ls`** - List directory contents:
   ```bash
   ls
   ```
   Lists files and directories in the current directory.

2. **`cd`** - Change directory:
   ```bash
   cd /home/pi/Documents
   ```
   Changes the directory to `/home/pi/Documents`.

3. **`touch`** - Create an empty file:
   ```bash
   touch file.txt
   ```
   Creates an empty file named `file.txt`.

4. **`mv`** - Move or rename files:
   ```bash
   mv file.txt newfile.txt
   ```
   Renames `file.txt` to `newfile.txt`.

5. **`rm`** - Remove files or directories:
   ```bash
   rm file.txt
   ```
   Deletes `file.txt`. Use `rm -r` for directories.

6. **`man`** - Display manual for a command:
   ```bash
   man ls
   ```
   Displays the manual page for the `ls` command.

7. **`mkdir`** - Create a directory:
   ```bash
   mkdir new_directory
   ```
   Creates a directory named `new_directory`.

8. **`rmdir`** - Remove an empty directory:
   ```bash
   rmdir new_directory
   ```
   Removes the empty directory `new_directory`.

9. **`tar`** - Archive files:
   ```bash
   tar -czf archive.tar.gz directory_name
   ```
   Compresses and archives the directory `directory_name` into `archive.tar.gz`.

10. **`gzip`** - Compress files:
    ```bash
    gzip file.txt
    ```
    Compresses `file.txt` to `file.txt.gz`.

11. **`cat`** - Concatenate and display file content:
    ```bash
    cat file.txt
    ```
    Displays the contents of `file.txt`.

12. **`more`** - View file content page by page:
    ```bash
    more file.txt
    ```
    Displays `file.txt` one page at a time.

13. **`less`** - View file content, allowing scrolling:
    ```bash
    less file.txt
    ```
    Displays `file.txt`, with the ability to scroll up and down.

14. **`ps`** - View running processes:
    ```bash
    ps
    ```
    Displays the list of currently running processes.

15. **`sudo`** - Run a command as superuser (root):
    ```bash
    sudo apt update
    ```
    Runs the `apt update` command as root (superuser) to update package information.

16. **`cron`** - Schedule tasks:
    - To edit the cron jobs:
      ```bash
      crontab -e
      ```
    - Example cron job: To run a script every day at 3 AM:
      ```bash
      0 3 * * * /home/pi/script.sh
      ```

17. **`chown`** - Change ownership of a file or directory:
    ```bash
    sudo chown pi:pi file.txt
    ```
    Changes the ownership of `file.txt` to the user `pi` and group `pi`.

18. **`chgrp`** - Change group ownership:
    ```bash
    sudo chgrp pi file.txt
    ```
    Changes the group ownership of `file.txt` to `pi`.

19. **`ping`** - Check network connection:
    ```bash
    ping google.com
    ```
    Sends ICMP packets to `google.com` to check if it's reachable.

### **Important Notes**:
- **`sudo`** is used to execute commands with root privileges. For example, when installing software or modifying system files, `sudo` is needed.
- **Man pages** (`man command_name`) provide detailed help for most Linux commands. For example, `man ls` will show options for the `ls` command.
- Some commands may need superuser (root) privileges to execute successfully, which is where `sudo` is helpful.

### **Example Workflow**:
```bash
# List files in the current directory
ls

# Create a new directory
mkdir my_directory

# Change into the new directory
cd my_directory

# Create an empty file
touch file1.txt

# Display contents of the file (empty initially)
cat file1.txt

# Compress the file
gzip file1.txt

# List the contents of the directory
ls

# Extract the compressed file
gunzip file1.txt.gz

# Display the contents again
cat file1.txt
```

By using these commands, you can perform various file operations, check system processes, schedule tasks, and manage system resources directly from the terminal on Raspberry Pi. */