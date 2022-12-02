# Contributing

## Development workflow

```shell
cd example
npm start
```

Make sure your code passes TypeScript and ESLint. Run the following to verify:

```sh
npm run typescript
npm run lint
```

To fix formatting errors, run the following:

```sh
npm run lint --fix
```

Remember to add tests for your change if possible. Run the unit tests by:

```sh
npm run test
```

To edit the Objective-C files, open `example/ios/ReactNativeGetIntentExample.xcworkspace` in XCode and find the source files at `Pods > Development Pods > react-native-get-intent`.

To edit the Kotlin files, open `example/android` in Android studio and find the source files at `reactnativegetintent` under `Android`.

### Publishing to npm

We use [release-it](https://github.com/release-it/release-it) to make it easier to publish new versions. It handles common tasks like bumping version based on semver, creating tags and releases etc.

To publish new versions, run the following:

```sh
npm run release
```

## Troubleshooting

### Error: EMFILE: too many open files, watch

If you are seeing this when running `npm start` in example:

```shell
Error: EMFILE: too many open files, watch
    at FSEvent.FSWatcher._handle.onchange (node:internal/fs/watchers:204:21)
```

For OSX users, it might be fixed by installing `watchman`:

```shell
brew install watchman
```
