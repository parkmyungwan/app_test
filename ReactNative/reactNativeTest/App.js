import React, {useState} from 'react';
import { Text, View, Button } from 'react-native';
import { WebView } from 'react-native-webview';
import analytics from '@react-native-firebase/analytics';

const App =  () => {
    const [shouldOpenWebview, setShouldOpenWebview] = useState(false);
    if (shouldOpenWebview) return <WebView source={{ uri: 'http://mywanpark.dothome.co.kr/rn-index.html' }} javaScriptEnabled={true}/>
    return (
        <View>
            <Text>hello world</Text>
            <Button
                onPress={
                    async () => {
                        await analytics().logSelectContent({
                            content_type: 'clothing',
                            item_id: 'abcd',
                        })
                        setShouldOpenWebview(true);
                    }}
                title= "button"
            />
        </View>
    );
};


export default App;
