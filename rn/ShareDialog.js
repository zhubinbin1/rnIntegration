import React, {Component} from 'react';
import {
    View,
    TouchableOpacity,
    Alert,
    StyleSheet,
    Dimensions,
    Modal,
    Text,
    Image
} from 'react-native';
//分享功能实现
const {width, height} = Dimensions.get('window');
const dialogH = 200;
const itemH = 100;
// import index from "../index"

 class ShareDialog extends Component {
    constructor(props) {
        super(props);
        this.state = {
            isVisible: false,
        };
    }

    // componentWillReceiveProps(nextProps) {
    //     this.setState({isVisible: nextProps.show});
    // }
    static getDerivedStateFromProps(props, state){
        return {isVisible: props.show}
    }

    closeModal() {
        this.setState({
            isVisible: false
        });
        this.props.closeModal && this.props.closeModal(false);
    }

    renderDialog() {
      // 通过网络获取图片
      let pic = {uri:'https://www.baidu.com/img/bd_logo1.png?where=super'}
        return (
            <View style={styles.modalStyle}>
                <Text style={styles.textStyle}>选择分享方式</Text>
                <View style={styles.shareModalStyle}>
                    <TouchableOpacity activeOpacity = {1.0} style={styles.itemStyle}
                      onPress={() => {Alert.alert('分享到微信朋友圈'),this.closeModal()}}>
                        <Image resizeMode='contain' style={styles.imageStyle}
                            source={pic}/>
                        <Text>微信朋友圈</Text>
                    </TouchableOpacity>
                    <TouchableOpacity activeOpacity = {1.0} style={styles.itemStyle}
                      onPress={() => Alert.alert('分享到微信')}>
                        <Image resizeMode='contain' style={styles.imageStyle}
                            source={require('./images/ride_ic_launcher.png')}/>
                        <Text>微信好友</Text>
                    </TouchableOpacity>
                    <TouchableOpacity activeOpacity = {1.0} style={styles.itemStyle}
                      onPress={() => Alert.alert('分享到微博')}>
                        <Image resizeMode='contain' style={styles.imageStyle}
                            source={require('./images/ride_ic_launcher.png')}/>
                        <Text>新浪微博</Text>
                    </TouchableOpacity>
                </View>
            </View>
        )
    }

    render() {
        return (
            <View style={{flex: 1}}>
                <Modal
                    transparent={true}
                    visible={this.state.isVisible}
                    animationType={'fade'}
                    onRequestClose={() => this.closeModal()}>
                    <TouchableOpacity style={styles.container} activeOpacity={1}
                                      onPress={() => this.closeModal()}>
                        {this.renderDialog()}
                    </TouchableOpacity>
                </Modal>
            </View>
        );
    }
}
export default class showShareDialog extends Component {
  constructor(props){
    super(props);
    this.state = {isShowShareDialog:true}
  }
  render(){
    return(
      <ShareDialog show = {this.state.isShowShareDialog}
	           closeModal = {(show) => {
	               this.setState({
	                    isShowShareDialog: show,
	                })
	            }
	        }
          >
</ShareDialog>
    )
  }
}
const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: 'rgba(0, 0, 0, 0.5)',
        flexDirection: 'column'
    },
    modalStyle: {
        position: "absolute", // 绝对位置
        top: height - dialogH,
        left: 0,
        width: width,
        height: dialogH,
        backgroundColor: '#ffffff',
    },
    shareModalStyle: {
        flex: 1,
        flexDirection: 'row',
        marginTop: 15,
    },
    textStyle: {
        // flex: 1, // 不要随便使用 flex = 1，会产生出莫名其妙的问题
        fontSize: 18,
        margin: 15,
        justifyContent: 'center',
        alignItems: 'center',
        alignSelf: 'center',
    },
    itemStyle: {
        width: width / 3,
        height: itemH,
        alignItems: 'center',
        backgroundColor: '#ffffff',
    },
    imageStyle: {
        width: 60,
        height: 60,
        marginBottom: 8
    },
});
