# react-native-get-intent

Get access to the Android Activity's intent

## Installation

```sh
npm install react-native-get-intent
```

## API and Usage

Currently, the API is very small, with just a `getIntent` function and a complementary `Intent` type.

```typescript
/**
 * Intent interface that is analogous to Android's Intent class.
 *
 * @see https://developer.android.com/reference/android/content/Intent
 */
export interface Intent {
  action: string;
  data: string;
  categories: string[];
  extras: { [k: string]: unknown };
}

/**
 * Gets the current Android activity's intent.
 *
 * @see https://developer.android.com/reference/android/app/Activity#getIntent()
 */
export function getIntent(): Promise<Intent>;
```

It's recommended to call `getIntent` when your app starts, or maybe when the `AppState` changes.
See the [example app](./example/src/App.tsx).

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT
