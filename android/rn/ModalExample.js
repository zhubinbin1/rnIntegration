import React, {Component} from 'react';
import {Modal, Text, TouchableHighlight,Dimensions, View, Alert} from 'react-native';
const {width ,height} = Dimensions.get("window")
// ModalExample
export default class ModalExample extends Component {
  state = {
    modalVisible: false,
  };

  setModalVisible(visible) {
    this.setState({modalVisible: visible});
  }

  render() {
    return (
      <View style={{marginTop: 22}}>
        <Modal
          animationType="slide"
          transparent={true}
          hardwareAccelerated={true}
          visible={this.state.modalVisible}
          onShow={()=>{
            // Alert.alert('onShow.');
              console.log("展示")
          }}
          onDismiss={()=>
            {
              Alert.alert('onDismiss.');
              console.log("消失");
            }
          }
          onRequestClose={() => {
            Alert.alert('Modal has been closed.');
          }}>
          <View style={{marginTop: height/2,backgroundColor: "red"}}>
            <View>
              <Text style={{fontSize:10}}>Hello World!</Text>

              <TouchableHighlight
                onPress={() => {
                  this.setModalVisible(!this.state.modalVisible);
                }}>
                <Text>Hide Modal</Text>
              </TouchableHighlight>
            </View>
          </View>
        </Modal>

        <TouchableHighlight style={{backgroundColor:'green'}}
          onPress={() => {
            this.setModalVisible(true);
          }}>
          <Text >Show Modal</Text>
        </TouchableHighlight>
      </View>
    );
  }
}
