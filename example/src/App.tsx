import React, { useEffect } from 'react';

import { AppState, StyleSheet, View, Text, AppStateStatus } from 'react-native';
import { Intent, getIntent } from 'react-native-get-intent';

export default function App() {
  const [intent, setIntent] = React.useState<Intent>();

  useEffect(() => {
    const subscription = AppState.addEventListener(
      'change',
      (state: AppStateStatus) => {
        if (state === 'active') {
          getIntent().then(setIntent);
        }
      }
    );
    return subscription.remove;
  }, []);

  return (
    <View style={styles.container}>
      <Text>Intent: {JSON.stringify(intent, null, 2)}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
