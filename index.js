import {AppRegistry} from 'react-native';
import update from './rn/update';
import {name as appName} from './package.json';
AppRegistry.registerComponent(appName, () => update);
