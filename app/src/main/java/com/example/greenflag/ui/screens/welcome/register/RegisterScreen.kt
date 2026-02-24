package com.example.greenflag.ui.screens.welcome.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RegisterScreen(
    onBack: () -> Unit,
    onNext: (String, String) -> Unit
) {
    // Registration states
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirm by remember { mutableStateOf("") }

    val emailValid = email.isNotBlank() && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    val pwValid = password.length >= 8 &&
            password.any { it.isDigit() } &&
            password.any { it.isUpperCase() } &&
            password.any { it.isLowerCase() }
    val match = password == confirm && confirm.isNotEmpty()

    val formValid = emailValid && pwValid && match

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(horizontal = 24.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBack) {
                Icon(Icons.Default.ArrowBack, "Back", tint = Color(0xFF4CAF50))
            }
            Spacer(Modifier.weight(1f))
            Text(
                "Create an account",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(Modifier.weight(1f))
        }
            // email field and button
        OutlinedTextField(
            value = email,
            onValueChange = { email = it.trim() },
            label = { Text("Email address") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF4CAF50),
                unfocusedBorderColor = Color.Gray,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
            )
        )

        Spacer(Modifier.height(24.dp))
                // password fields
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Create password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF4CAF50),
                unfocusedBorderColor = Color.Gray,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
            )
        )

        Spacer(Modifier.height(24.dp))
            // insuring password is correct
        OutlinedTextField(
            value = confirm,
            onValueChange = { confirm = it },
            label = { Text("Repeat password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF4CAF50),
                unfocusedBorderColor = Color.Gray,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
            )
        )

        Spacer(Modifier.height(32.dp))

        Text(
            text = "Your password should have a minimum of 8 characters and contain at least one number, one uppercase and one lowercase letter. You can use special characters.",
            color = Color.LightGray,
            fontSize = 14.sp,
            lineHeight = 20.sp
        )

        Spacer(Modifier.weight(1f))
        // next button validator
        Button(
            onClick = { onNext(email, password) },
            enabled = formValid,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
        ) {
            Text("Next", color = Color.White, fontSize = 18.sp)
        }

        Spacer(Modifier.height(32.dp))
    }
}