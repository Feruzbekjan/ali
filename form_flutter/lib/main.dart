import 'package:flutter/material.dart';

void main(){
  runApp(MyApp());
}


class MyApp extends StatefulWidget {
   MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  final _fromKey = GlobalKey<FormState>();

  @override
  Widget build(BuildContext context) {
  
    return MaterialApp(
      home: SafeArea(
        child: Scaffold(
          body: Builder(
            builder: (context) {
              return Column(
                children: [
                  Form(
                      key: _fromKey,
                      child: Column(
                        children: [
                          TextFormField(
                            validator: (value) {
                              if(value==null||value.isEmpty){
                                return "To'g'ri yoz";
                              }
                              return null;
                            },
                            
                          ),
                          ElevatedButton(
                            onPressed:() {
                              if(_fromKey.currentState!.validate()){
                                ScaffoldMessenger.of(context).showSnackBar(
                                  SnackBar(content: Text("Procesing data")),
                                  );
                              }
      
                            }, 
                            child: Text("Sumbit"),
                          ),
                        ],
                      ),
                    ),
                ],
              );
            }
          ),
        ),
      ),
    );
  }
}