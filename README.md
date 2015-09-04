# Cookieminer

Wiki: http://cookiecraft.wikia.com/wiki/Getting_Started

## Nice to have commands

- Reset the workspace:

    ```bash
    git clean -dfx
    ```

- Install forge with sources for Intellij Idea

    ```bash
    gradlew setupDecompWorkspace idea
    ```

- Build the mod jar file to `./build/libs/`

    ```bash
    gradlew build
    ```

- `git all` alias

    ```bash
    [alias]
    	all = "!sh -c 'git add -A ; git commit -m \"$1\" ; git push' -"
    ```
    Usage: `git all "message"`

- Clear the saves folder
    ```
    ./clear-saves
    ```
