import React from 'react';
import {AppRegistry, StyleSheet, Button,Text, View} from 'react-native';

class HelloWorld extends React.Component {
  componentDidUpdate(prevProps, prevState, snapshot){
      console.log("componentDidUpdate")
  }
  componentDidMount(){
  // alert("你好!")
  console.log("zhubin===componentDidMount!")
  }
  _hello(){
     alert("你好!")
  }
  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.hello}>Hello, zhubin</Text>
      <Button title="按钮" style = {styles.btn} onPress={this._hello}></Button>
      </View>
    );
}
}
var styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
  },
  btn:{
    fontSize: 10,
    marginTop: 10,
  },
  hello: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
});

AppRegistry.registerComponent('rn_project', () => HelloWorld);
