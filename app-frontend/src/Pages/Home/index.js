import React from 'react';
import './GamePage.css'
import localImage from '../../imgs/img2.png';
import { useNavigate  } from 'react-router-dom';
import { makeInitialCall } from '../../Services/CallBackend'

function Home() {

    const navigate = useNavigate(); // Hook para navegar

    const botaoIniciar = async () => {
        const animal = await makeInitialCall();
        navigate('/chat', { state: { animal } }); // Rota para a página do chat
    }

    return (
        <div className="game-container">
            {/* Imagem no topo */}
            <img
                src={localImage}
                alt="Logo do Jogo"
                className="game-image"
            />

            {/* Instruções */}
            <div className="game-instructions">
                <h2>Como Jogar:</h2>
                <p>
                    1. Você é um animal! <br />
                    2. Faça perguntas de "sim" ou "não" para adivinhar qual animal você é. <br />
                    3. Continue perguntando até acertar! <br />
                    4. Clique no botão "iniciar" abaixo para começar. Divirta-se!
                </p>
            </div>

            {/* Botão de iniciar */}
            <button className="start-button" onClick={botaoIniciar}>Iniciar</button>
        </div>
    );
}

export default Home;