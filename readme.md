# Watermarking Tool

The project is split into two halves, the server side and the client side.

## Server

To run the server, simply change directories into the server folder and run
the appropriate command:

```shell
cd server
./gradlew bootRun # unix-like
gradlew.bat bootRun # windows
```

If you want to format the codebase, you can run the gradle command `spotlessApply`.
This is deterministic and config-free. Formatting issues will prevent a
production build, so make sure to apply formatting correctly. We currently target
java 11 (as seen in `build.gradle`) so make sure you have that in your environment.
You can also use `jibDockerBuild` to create a minimal docker container, which can 
run as long as the host has docker (or podman) available.

## Client

The client is built using `next`, and utilises css-in-js along with `twin.macro`
for styling. The client api for the server is generated using a tool called `orval`,
which can be invoked to synchronize the client code with the server openapi definitions
after making changes.

```shell
cd web
yarn api:sync
```

The resulting service definitions (fully typed) are generated into `src/service`,
and available as hooks, using `react-query` for persistence and caching.

Other commands are available in `package.json`

```shell
yarn dev # development server
yarn build # production build
```

## Formatting

You may want to automatically format file on save. To do this, if using
vscode, you can simply use a plugin "Spotless Gradle", and set up a save
hook to call it. It will automatically find your config and invoke the
appropriate command. To install, open the command palette (CTRL+P) then:

```
ext install richardwillis.vscode-spotless-gradle
```

`.vscode/settings.json`
```json5
{
  "[java]": {
    "editor.codeActionsOnSave": {
      "source.fixAll.spotlessGradle": true
    },
    "spotlessGradle.format.enable": true,
    "spotlessGradle.diagnostics.enable": true,
    "editor.defaultFormatter": "richardwillis.vscode-spotless-gradle",
    "files.trimTrailingWhitespace": false
  }
}
```

The setup for the client is similar. Note that this also sets up the tailwind
plugin so that it properly detects and autocompletes classes for you, if you
wish to use that.

```
ext install dbaeumer.vscode-eslint
```

`.vscode/settings.json`
```json5
{
  "editor.formatOnSave": false,
  "editor.codeActionsOnSave": {
    "source.addMissingImports": true,
    "source.fixAll.eslint": true
  },
  // optional
  "tailwindCSS.experimental.classRegex": [
    "tw`([^`]*)", // tw`...`
    "tw=\"([^\"]*)", // <div tw="..." />
    "tw={\"([^\"}]*)", // <div tw={"..."} />
    "tw\\.\\w+`([^`]*)", // tw.xxx`...`
    "tw\\(.*?\\)`([^`]*)" // tw(Component)`...`
  ],
  "tailwindCSS.includeLanguages": {
    "typescript": "javascript",
    "typescriptreact": "javascript"
  }
}
```
