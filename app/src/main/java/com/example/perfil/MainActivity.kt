package com.example.perfil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.perfil.ui.theme.PerfilTheme

// Definición de paleta morada personalizada
val FondoOscuro = Color(0xFF120E1E)
val TarjetaMorada = Color(0xFF1E1735)
val MoradoAcento = Color(0xFF9D4EDD)
val MoradoBrillante = Color(0xFFC77DFF)
val TextoSecundario = Color(0xFFE0AFA0)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PerfilTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(FondoOscuro)
                        .statusBarsPadding()
                        .verticalScroll(rememberScrollState())
                        .padding(bottom = 24.dp)
                ) {
                    // Título eSports destacado
                    Text(
                        text = "TEAM TITANS",
                        color = MoradoBrillante,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Black,
                        modifier = Modifier
                            .padding(top = 24.dp, bottom = 16.dp)
                            .align(Alignment.CenterHorizontally)
                    )

                    // 1. Pablo
                    Jugador(
                        nombre = "Pablo",
                        rol = "Atacante",
                        edad = 21,
                        nivel = 87,
                        imagen = R.drawable.pablo
                    )

                    HorizontalDivider(
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 6.dp),
                        thickness = 1.dp,
                        color = MoradoAcento.copy(alpha = 0.3f)
                    )

                    // 2. Pau
                    Jugador(
                        nombre = "Pau",
                        rol = "Defensor",
                        edad = 24,
                        nivel = 91,
                        imagen = R.drawable.pau
                    )

                    HorizontalDivider(
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 6.dp),
                        thickness = 1.dp,
                        color = MoradoAcento.copy(alpha = 0.3f)
                    )

                    // 3. Josune
                    Jugador(
                        nombre = "Josune",
                        rol = "Soporte",
                        edad = 20,
                        nivel = 84,
                        imagen = R.drawable.josune
                    )

                    HorizontalDivider(
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 6.dp),
                        thickness = 1.dp,
                        color = MoradoAcento.copy(alpha = 0.3f)
                    )

                    // 4. Andrea
                    Jugador(
                        nombre = "Andrea",
                        rol = "Atacante",
                        edad = 23,
                        nivel = 89,
                        imagen = R.drawable.andrea
                    )
                }
            }
        }
    }
}

@Composable
fun Jugador(
    nombre: String,
    rol: String,
    edad: Int,
    nivel: Int,
    @DrawableRes imagen: Int
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(TarjetaMorada)
            .border(1.dp, MoradoAcento.copy(alpha = 0.4f), RoundedCornerShape(16.dp))
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Imagen con borde morado circular
            Image(
                painter = painterResource(id = imagen),
                contentDescription = "Foto de $nombre",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(75.dp)
                    .clip(CircleShape)
                    .border(2.dp, MoradoBrillante, CircleShape)
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Datos ordenados
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = nombre,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = "Rol: $rol",
                    fontSize = 14.sp,
                    color = MoradoBrillante,
                    fontWeight = FontWeight.Medium
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.padding(top = 4.dp)
                ) {
                    Text(
                        text = "$edad años",
                        fontSize = 13.sp,
                        color = Color.LightGray
                    )

                    Text(
                        text = "Nivel: $nivel",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = MoradoAcento
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun JugadorPreview() {
    PerfilTheme {
        Jugador(
            nombre = "Pablo",
            rol = "Atacante",
            edad = 21,
            nivel = 87,
            imagen = R.drawable.pablo
        )
    }
}