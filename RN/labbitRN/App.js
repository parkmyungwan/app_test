import React, {useState} from 'react';
import { Text, View, Button } from 'react-native';
import { WebView } from 'react-native-webview';

const App =  () => {
    const [shouldOpenWebview, setShouldOpenWebview] = useState(false);
    if (shouldOpenWebview) return <WebView source={{ uri: 'https://labbit.kr/' }} />
    return (
        <View>
            <Text>hello world</Text>
            <Button
                onPress={() => setShouldOpenWebview(true)}
                title= "button"
            />
        </View>
    );
};


export default App;
