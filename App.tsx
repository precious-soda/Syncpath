import { NativeModules } from 'react-native';
const {HealthConnectModule}=NativeModules;
import React, { useEffect, useState } from 'react';
import {
  StyleSheet,
  Text,
  View,
} from 'react-native';
// import Realm from 'realm';

function App(): React.JSX.Element {

  useEffect(()=>{
      HealthConnectModule.checkAvailability()
      .then((isAvailable:boolean)=>{
      console.log("Health Connect available:",isAvailable)
    })
    .catch((error:any)=>{
      console.error('Error checking Health Connect availability:', error);
    })
  },[])

  return (
    <View>
      <Text>Hello</Text>
    </View>
  );
}

const styles = StyleSheet.create({
 
});

export default App;
