async function removeProduct(id) {
  try {
    const response = await fetch(`/products/${id}`, {
      method: "DELETE",
    });

    if (!response.ok) {
      console.error("Erro ao remover produto");
      return;
    }

    updateProductsUI();
  } catch (error) {
    console.error("Erro ao remover produto:", error);
  }
}

async function favoriteProduct(id) {
  try {
    const response = await fetch(`/products/${id}/favorite`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
    });

    if (!response.ok) {
      console.error("Erro ao favoritar produto");
      return;
    }

    updateProductsUI();
  } catch (error) {
    console.error("Erro ao favoritar produto:", error);
  }
}
