import React, {
  Component,
} from 'react';

import {
  AppRegistry,
  StyleSheet,
  Platform,
  Text,
  View,
  Alert,
  Button,
  TouchableOpacity,
  Linking,
} from 'react-native';

import {
  isFirstTime,
  isRolledBack,
  packageVersion,
  currentVersion,
  checkUpdate,
  downloadUpdate,
  switchVersion,
  switchVersionLater,
  markSuccess,
} from 'react-native-update';

import _updateConfig from '../update.json';
const {appKey} = _updateConfig[Platform.OS];

class MyProject extends Component {
  _pressEvent(){
    console.log("你好啊");
    console.log("你好啊222");
     // Alert.alert('提示', '您的应用版本已是最新.');
  }
  render(){
    return(
      <View style ={styles.container}>
        <Text style = {styles.welcome}>
          你好
        </Text>
        <TouchableOpacity>
        <Button title="按钮" onPress={this._pressEvent}></Button>
      </TouchableOpacity>
    </View>
    )
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    flexDirection: 'row',
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  btn: {
    textAlign: 'center',
    color: '#ffffff',
    marginTop: 20,
    marginBottom: 5,
  },
});
export default MyProject
//AppRegistry.registerComponent('rn_project', () => MyProject);
