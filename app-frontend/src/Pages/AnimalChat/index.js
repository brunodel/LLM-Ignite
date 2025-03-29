import React, { useState, useEffect, useRef } from 'react';
import './ChatPage.css';
import { callMessageChat } from '../../Services/CallBackend'
import { useNavigate  } from 'react-router-dom';
import bonecoIA from '../../imgs/so_boneco_ia.png';
import textoIA from '../../imgs/texto_ia.png';
import { useLocation } from "react-router-dom";

function AnimalChat() {

    const initMessage = { text: "O jogo \"Quem Sou Eu?\" começou! \uD83C\uDF89 \n \n" +
        "Você é um animal, mas não sabe qual. Seu objetivo é adivinhar qual animal você é.\n" +
        "\n" +
        "Regras:\n" +
        "\n" +
        "Você pode fazer perguntas para tentar descobrir, mas as respostas serão apenas \"sim\", \"não\" ou \"não sei\".\n" +
        "Continue perguntando até descobrir o animal!\n" +
        "Agora é com você! Pode começar fazendo a sua primeira pergunta. Boa sorte! 🐾🐾", sender: 'server' };

    const navigate = useNavigate(); // Hook para navegar

    const [messages, setMessages] = useState([initMessage]); // Armazena as mensagens
    const [input, setInput] = useState(''); // Armazena o texto digitado pelo usuário

    const location = useLocation();
    const { animal } = location.state || {}; // Verifica se o estado foi passado

    const chatContainerRef = useRef(null);

    useEffect(() => {
        debugger
        // Rola para o final da div sempre que o componente for atualizado
        if (chatContainerRef.current) {
          chatContainerRef.current.scrollTop = chatContainerRef.current.scrollHeight;
        }
      }, []);

      useEffect(() => {
        debugger
        // Rola para o final da div sempre que o componente for atualizado
        if (chatContainerRef.current) {
          chatContainerRef.current.scrollTop = chatContainerRef.current.scrollHeight;
        }
      }, [messages]);

    // Função para enviar mensagem
    const sendMessage = async () => {
        if (!input.trim()) return;

        // Adiciona a mensagem do usuário na lista de mensagens
        const userMessage = { text: input, sender: 'user' };
        setMessages((prevMessages) => [...prevMessages, userMessage]);
        
        await callMessageChat(input.trim(), setMessages, animal, chatContainerRef);
        
        debugger
        setInput(''); // Limpa o campo de entrada
    };

    const voltar = () => {
        navigate('/'); // Rota para a página do chat
    }

    const printMessage = (message) => {
        return true;
    }

    return (
        <div className="wholeScreen">

            <div className="header">
                <img
                    src={bonecoIA}
                    alt="Boneco IA"
                    className="robot-img"
                />
                <img
                    src={textoIA}
                    alt="Texto IA"
                    className="text-img"
                />

                {/* <button className="go-back-button" onClick={voltar}>
                    Voltar
                </button> */}
            </div>

            <div className="chat-container" ref={chatContainerRef}>
            {/* Área de exibição do chat */}
            <div className="chat-messages">
                {messages.map((msg, index) => (
                    <div
                        key={index}
                        className={`chat-message ${msg.sender === 'user' ? 'user-message' : 'server-message'}`}
                    >
                        {/* {msg.text } */}
                        {msg.text.split('\n').map((line, index) => (
                            <p key={index} style={{ margin: '0.3rem' }}> {line}</p>
                        ))}
                    </div>
                ))}
            </div>

            {/* Área de entrada de texto e botão de enviar */}
            <div className="chat-input-container">
                <input
                    type="text"
                    className="chat-input"
                    placeholder="Digite sua mensagem..."
                    value={input}
                    onChange={(e) => setInput(e.target.value)}
                    onKeyPress={(e) => e.key === 'Enter' && sendMessage()} // Envia ao pressionar Enter
                />
                <button className="chat-send-button" onClick={sendMessage}>
                    Enviar
                </button>
            </div>
        </div>
        </div>
    );
}

export default AnimalChat;