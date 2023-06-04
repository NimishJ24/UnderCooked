package com.plcoding.bluetoothchat.presentation.components

import android.graphics.Color.rgb
import android.util.Log
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.bluetoothchat.domain.chat.BluetoothDevice
import com.plcoding.bluetoothchat.presentation.BluetoothUiState


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text

import androidx.compose.ui.Alignment

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun DeviceScreen(
    state: BluetoothUiState,
    onStartScan: () -> Unit,
    onStopScan: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar(
            title = { Text(text = "BlueAlert") },
            backgroundColor = Color(rgb(0, 20, 90)),
            modifier = Modifier.fillMaxWidth()
        )
        BluetoothDeviceList(
            pairedDevices = state.pairedDevices,
            scannedDevices = state.scannedDevices,
            onClick = {},
            modifier = Modifier.fillMaxWidth().weight(1f)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 15.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = onStartScan,
                shape = RoundedCornerShape(percent = 50),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)
            ) {
                Text(text = "Start scan")
            }
            Button(
                onClick = onStopScan,
                shape = RoundedCornerShape(percent = 50),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(rgb(166, 0, 0)))
            ) {
                Text(text = "Stop scan")
            }
        }
    }
}

@Composable
fun BluetoothDeviceList(
    pairedDevices: List<BluetoothDevice>,
    scannedDevices: List<BluetoothDevice>,
    onClick: (BluetoothDevice) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        item {
            Text(
                text = "Scanned Devices",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.padding(16.dp)
            )
        }
        itemsIndexed(scannedDevices) { index, device ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onClick(device) }
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = device.name ?: "(No name)",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = device.address ?: "(No address)",
                        fontSize = 12.sp,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                }
                Text(
                    text = String.format("%d", ((countFunction(device.address)?.toInt() ?: 0))),
                    modifier = Modifier.padding(start = 8.dp)
                )

            }
            if (index < scannedDevices.size - 1) {
                Divider(modifier = Modifier.padding(horizontal = 16.dp))
            }
        }
    }
}



val mutableDict = hashMapOf<String, Int>()
var list = arrayOf<String>("hello")
fun countFunction(address: String?): Int? {

    if (address == null) {
        return null
    }


    if (address in list) {
        return mutableDict[address]
    }else{
        list += address
    }




    var count = mutableDict[address]?:0
    if (address in mutableDict.keys){
        Log.d(">>>","hello00")
        mutableDict[address]= count + 1
        return mutableDict[address]
    }


    mutableDict[address] = 1
    return mutableDict[address]
}
fun empty(){
    list=arrayOf<String>("hello")
    for(element in list){

    }
    for (ele in mutableDict.keys){

    }
}